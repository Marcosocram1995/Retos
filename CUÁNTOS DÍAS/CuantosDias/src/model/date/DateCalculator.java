package model.date;

import model.year.LeapYear;
import model.year.Year;

public interface DateCalculator {
    static int calculateDaysSinceUntil(MyDate initialDate, MyDate lastDate) {
        checkDates(initialDate, lastDate);
        int day = (calculateRemainingDays(initialDate) - calculateRemainingDays(lastDate));
        day += calculateYears(initialDate.getYear(), lastDate.getYear());
        return day;
    }

    private static void checkDates(MyDate initialDate, MyDate lastDate) {
        if (createValue(initialDate) > createValue(lastDate)) {
            throw new IllegalArgumentException("La fecha inicial no puede ser mayor que la última");
        }
    }

    private static int createValue(MyDate date) {
        return date.getDay() + date.getMonth() / 100 + date.getYear() * 100;
    }

    private static int calculateRemainingDays(MyDate date) {
        if (isLeapYear(date.getYear())) {
            LeapYear leapYear = new LeapYear();
            checkFebruary(date, leapYear);
            return leapYear.getDaysSince(date.getMonth(), Year.TOTAL_MONTH) - date.getDay();
        }
        Year year = new Year();
        checkFebruary(date, year);
        return year.getDaysSince(date.getMonth(), Year.TOTAL_MONTH) - date.getDay();
    }

    private static void checkFebruary(MyDate date, Year year) throws IllegalArgumentException {
        if (date.getMonth() == Year.FEBRUARY_NUMBER
                && date.getDay() > year.getMonths().get(Year.FEBRUARY_NUMBER - 1).getDay()) {
            throw new IllegalArgumentException("El día está incorrecto");
        }
    }

    private static int calculateYears(int initialYear, int lastYear) {
        int days = 0;
        for (int i = initialYear; i < lastYear; i++) {
            if (isLeapYear(i)) {
                days += new LeapYear().getYearDays();
            } else {
                days += new Year().getYearDays();
            }
        }
        return days;
    }

    private static boolean isLeapYear(int year) {
        boolean leapYear = false;
        if (year % 4 == 0
                && year % 100 != 0
                || year % 400 == 0) {
            leapYear = true;
        }
        return leapYear;
    }
}
