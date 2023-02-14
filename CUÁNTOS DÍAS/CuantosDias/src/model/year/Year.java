package model.year;

import model.year.month.*;

import java.util.ArrayList;
import java.util.List;

public class Year {
    protected final List<Month> months;
    private final int JULY_NUMBER = 7;
    public static final int TOTAL_MONTH = 12;
    public static final int FEBRUARY_NUMBER = 2;

    public List<Month> getMonths() {
        return months;
    }

    public int getYearDays() {
        final int[] days = {0};
        months.forEach(month -> days[0] = days[0] + month.getDay());
        return days[0];
    }

    public int getDaysSince(int initialMonth, int lastMonth) {
        int days = 0;
        for (int i = initialMonth - 1; i <= lastMonth - 1; i++) {
            days = days + months.get(i).getDay();
        }
        return days;
    }

    public Year() {
        this.months = new ArrayList<>();
        createYear();
    }

    protected void createYear() {
        addMonths(JULY_NUMBER / 2);
        addMonths((TOTAL_MONTH - JULY_NUMBER) / 2);
        months.set(FEBRUARY_NUMBER - 1, new FebruaryMonth());
    }


    protected void addMonths(int count) {
        for (int i = 0; i < count; i++) {
            months.add(new LargeMonth());
            months.add(new ShortMonth());
        }
        months.add(new LargeMonth());
    }
}
