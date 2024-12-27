package main;

import model.Product;
import model.VendingMachine;
import model.money.Coin;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        createList(productList);
        VendingMachine vending = new VendingMachine(productList);
        vending.enterCoin(Coin.TWOEURO);
        vending.initialize();
    }

    private static void createList(List<Product> productList) {
        productList.add(new Product(1, "Golosinas", 5.5f, 5));
        productList.add(new Product(2, "Chocolate", 7, 6));
        productList.add(new Product(3, "Agua", 2.5f, 1));
        productList.add(new Product(4, "Patatas", 3.99f, 7));
        productList.add(new Product(5, "Frutos secos", 0.98f, 1));
    }
}