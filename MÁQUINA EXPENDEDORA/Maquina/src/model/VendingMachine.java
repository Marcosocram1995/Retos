package model;

import model.money.Coin;
import model.money.CoinPurse;
import utils.Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VendingMachine {
    private final List<Product> products;
    private final CoinPurse coinPurse;
    private final Printer printer;
    private final Checker checker;
    private final int EXIT_ID = 999;

    public void initialize() {
        printer.welcome();
        coinPurse.calculateMoney();
        printer.showBalance(coinPurse.getBalance());
        printer.showCash(coinPurse.getCash());
        printer.printProductList(products);
        loop();
    }

    private void loop() {
        int id = printer.introduceNumber();
        exitIfIsEXIT(id);
        tryBuy(id);
    }

    private void exitIfIsEXIT(int id) {
        if (id == EXIT_ID) {
            coinPurse.transferBalanceToCash();
            printer.showReturnedCoins(coinPurse.calculateReturnedCoins());
            checkIfAllBalanceAreReturned();
            initialize();
        }
    }

    private void checkIfAllBalanceAreReturned() {
        if (coinPurse.getBalance() > 0) {
            printer.weAreInTrouble();
        }
    }

    private void tryBuy(int id) {
        try {
            buy(id);
        } catch (InterruptedException e) {
            if (!Thread.interrupted()) {
                Thread.currentThread().interrupt();
            }
            initialize();
        }
    }

    private void buy(long id) throws InterruptedException {
        Optional<Product> product = getProductById(id);

        if (product.isPresent() && printer.printSelected(product.get())) {
            if (product.get().getPrice() <= coinPurse.getBalance() && product.get().getAmount() > 0) {
                printer.printBuying();
                coinPurse.subtractBalance(product.get());
                product.get().subtractAmount();
                printer.printBuyed();
                printer.showBalance(coinPurse.getBalance());
            } else if (product.get().getPrice() >= coinPurse.getBalance()) {
                printer.insufficientBalance();
            } else {
                printer.outOfStock();
            }
        } else if (product.isEmpty()) {
            printer.printInvalidId();
        }
        printer.printProductList(products);
        loop();
    }

    private Optional<Product> getProductById(long id) {
        return products.stream().filter(p -> p.getId() == id).findFirst();
    }

    public void enterCoin(Coin coin) {
        coinPurse.addCoinToBalance(coin);
    }

    public VendingMachine(List<Product> products) throws IllegalArgumentException {
        this.products = new ArrayList<>();
        this.coinPurse = new CoinPurse();
        this.printer = new Printer();
        this.checker = new Checker(products);
        checkRepeated();
        this.products.addAll(checker.getWithoutRepeated());
    }

    private void checkRepeated() {
        if (checker.isRepeated()) {
            printer.printIdsRepeated();
        }
    }

    @Override
    public String toString() {
        return printer.showVendingMachine(products, coinPurse.getBalance(), coinPurse.getCash());
    }
}
