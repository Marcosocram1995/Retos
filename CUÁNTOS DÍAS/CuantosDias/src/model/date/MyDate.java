package model.date;

import model.year.Year;

public abstract class MyDate {
    private final int day;
    private final int month;
    private final int year;
    private final int DAY_MAX = 31;
    private final int YEAR_MAX = Integer.MAX_VALUE;

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    protected MyDate(String day, String month, String year) {
        this.month = parseIntString(month);
        this.day = parseIntString(day);
        this.year = parseIntString(year);
        check(this.day, DAY_MAX);
        check(this.month, Year.TOTAL_MONTH);
        check(this.year, YEAR_MAX);
    }

    private int parseIntString(String string) {
        int number;
        try {
            number = Integer.parseInt(string);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("La fecha solo debe contener números");
        }
        return number;
    }

    private void check(int check, int max) {
        if (check > max || check <= 0) {
            throw new IllegalArgumentException("Fecha inexistente");
        }
    }

    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }
}
