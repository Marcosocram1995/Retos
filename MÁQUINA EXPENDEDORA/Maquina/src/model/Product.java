package model;

import utils.MyDecimalFormat;

public class Product {
    private final long id;
    private final String name;
    private final float price;
    private int amount;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public void subtractAmount() {
        amount--;
    }

    public int getAmount() {
        return amount;
    }

    public Product(long id, String name, float price, int amount) throws IllegalArgumentException {
        if (amount < 0) {
            throw new IllegalArgumentException("'amount' no puede ser menor a 0");
        }
        if (id <= 0) {
            throw new IllegalArgumentException("'id' no puede ser menor o igual 0");
        }
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    @Override
    public String toString() {
        String outStock = " [AGOTADO]";
        String toString = "Id:" + id + " " + name + " " + new MyDecimalFormat(2, price).getNumberString() + " €";
        if (amount == 0) {
            toString += outStock;
        }
        return toString + "\n";
    }
}
