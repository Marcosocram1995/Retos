package model.year;

import model.year.month.LeapMonth;

public class LeapYear extends Year {

    public LeapYear() {
        super();
        createLeapYear();
    }

    private void createLeapYear() {
        months.set(FEBRUARY_NUMBER - 1, new LeapMonth());
    }
}