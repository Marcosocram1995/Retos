package model.money;

import model.Product;
import utils.MyDecimalFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinPurse {
    private final List<Coin> cashCoinList;
    private final List<Coin> balanceCoinList;
    private float balance;
    private float cash;
    private final int COIN_AMOUNT = 2;

    public CoinPurse() {
        cashCoinList = new ArrayList<>();
        cashCoinListDefault();
        balanceCoinList = new ArrayList<>();
    }

    private void cashCoinListDefault() {
        List<Coin> coinList = Arrays.stream(Coin.values()).toList();
        for (Coin coin : coinList) {
            for (int i = 0; i < COIN_AMOUNT; i++) {
                cashCoinList.add(coin);
            }
        }
    }

    public float getBalance() {
        return balance;
    }

    public float getCash() {
        return cash;
    }

    public void calculateMoney() {
        calculateBalance();
        calculateCash();
    }

    public List<Coin> calculateReturnedCoins() {
        List<Coin> returnedCoins = new ArrayList<>();
        int count = cashCoinList.size() - 1;

        count = getCount(count);

        do {
            returnedCoins.add(cashCoinList.get(count));
            balance = new MyDecimalFormat(2, balance - cashCoinList.get(count).getValue()).getNumberFloat();
            cashCoinList.remove(count);
            count--;
            count = getCount(count);
        } while (count >= 0 && cashCoinList.get(count).getValue() <= balance);
        return returnedCoins;
    }

    private int getCount(int count) {
        while (count >= 0 && cashCoinList.get(count).getValue() > balance && balance >= Coin.ONECENT.getValue()) {
            count--;
        }
        return count;
    }

    private void calculateBalance() {
        balance = calculateValue(balanceCoinList);
    }

    private void calculateCash() {
        cash = calculateValue(cashCoinList);
    }

    private float calculateValue(List<Coin> list) {
        final float[] result = {0};
        list.forEach(b -> result[0] += b.getValue());
        return result[0];
    }

    public void addCoinToBalance(Coin coin) {
        balanceCoinList.add(coin);
    }

    public void subtractBalance(Product product) {
        balance -= product.getPrice();
        cash += product.getPrice();
    }

    public void transferBalanceToCash() {
        cashCoinList.addAll(balanceCoinList);
        List<Coin> orderedList = cashCoinList.stream().sorted().toList();
        cashCoinList.clear();
        cashCoinList.addAll(orderedList);
        balanceCoinList.clear();
    }
}
