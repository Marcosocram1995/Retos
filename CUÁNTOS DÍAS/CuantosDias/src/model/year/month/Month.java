package model.year.month;

public abstract class Month {
    private int day;

    public Month(int day) {
        this.day = day;
    }

    public int getDay() {
        return day;
    }
}
