package main;

import model.date.DateCalculator;
import model.date.MyDateFormat;

public class Main {
    public static void main(String[] args) {
        MyDateFormat initalDate = new MyDateFormat("23/04/1995");
        MyDateFormat lastDate = new MyDateFormat("23/04/2023");
        int days = DateCalculator.calculateDaysSinceUntil(initalDate, lastDate);

        System.out.println("Desde el " + initalDate + " hasta el " + lastDate
                + " han pasado " + days + " días.");
    }
}