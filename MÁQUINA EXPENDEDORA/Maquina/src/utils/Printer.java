package utils;

import model.Product;
import model.money.Coin;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Printer {

    private final Scanner sc = new Scanner(System.in);
    private final int millis = 1500;

    private void print(String text) {
        System.out.println(text);
    }

    public void welcome() {
        print("¡Bienvenido/a!\n¿Qué desea comprar?");
    }

    public void showBalance(float balance) {
        print("\nEste es su saldo: " + new MyDecimalFormat(2, balance).getNumberString() + " €");
    }

    public void showCash(float balance) {
        print("Este es el dinero de la máquina: " + new MyDecimalFormat(2, balance).getNumberString() + " €");
    }

    public void insufficientBalance() {
        print("Saldo insuficiente");
    }

    public void outOfStock() {
        print("Este producto está agotado");
    }

    public boolean printSelected(Product product) {
        print("Seleccionaste " + product.getName());
        return areYouSure();
    }

    public void printIdsRepeated() {
        print("Hay Id's repetidos...");
    }

    private boolean areYouSure() {
        String cancelButton = "0";
        boolean sure = true;
        print("¿Es correcto?\nPulse " + cancelButton + " para cancelar");
        String answer = sc.nextLine();
        if (answer.equals(cancelButton)) {
            sure = false;
        }
        return sure;
    }

    public void printBuying() throws InterruptedException {
        StringBuilder builder = new StringBuilder("Comprando");
        print(builder.toString());
        builder.delete(0, builder.capacity());
        for (int i = 0; i < 3; i++) {
            builder.append(".");
            System.out.println(builder);
            Thread.sleep(millis);
        }
    }

    public void printInvalidId() {
        print("Id incorrecto");
    }

    public void printBuyed() throws InterruptedException {
        print("¡Gracias por comprar!");
        Thread.sleep(millis);
    }

    public void printProductList(List<Product> productList) {
        StringBuilder text = new StringBuilder("\nProductos:\n");
        productList.forEach(text::append);
        print(text.toString());
    }

    public int introduceNumber() {
        int number = 0;
        print("Introduzca un id");
        try {
            number = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException ignored) {
        }
        return number;
    }

    public String showVendingMachine(List<Product> products, float balance, float cash) {
        StringBuilder string = new StringBuilder("Máquina expendedora\nProductos:\n\n");

        products.forEach(string::append);

        string.append("\n{Saldo disponible = ").
                append(new MyDecimalFormat(2, balance).getNumberString()).
                append(" €}");

        string.append("\n{Dinero de la máquina = ").
                append(new MyDecimalFormat(2, cash).getNumberString()).
                append(" €}\n");

        return string.toString();
    }

    public void weAreInTrouble() {
        print("Contacte con un supervisor, ¡no tenemos cambio!");
    }

    public void showReturnedCoins(List<Coin> returnedCoins) {
        HashMap<String, Integer> frecuencyMap = countRepeated(returnedCoins);
        print("\nDinero devuelto:\n");
        frecuencyMap.forEach((s, integer) -> print(s + " " + integer));
        print("");
    }

    private HashMap<String, Integer> countRepeated(List<Coin> returnedCoins) {
        HashMap<String, Integer> frecuencyMap = new HashMap<>();
        for (Coin coin : returnedCoins) {
            if (frecuencyMap.containsKey(coin.name())) {
                frecuencyMap.put(coin.name(), frecuencyMap.get(coin.name()) + 1);
            } else {
                frecuencyMap.put(coin.name(), 1);
            }
        }
        return frecuencyMap;
    }

    public void byebye(){
        print("¡Adiós, pase buen día!");
    }
}
