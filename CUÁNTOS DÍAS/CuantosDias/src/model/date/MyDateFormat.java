package model.date;

public class MyDateFormat extends MyDate {
    public MyDateFormat(String date) {
        super(separateDate(date)[0], separateDate(date)[1], separateDate(date)[2]);
    }

    private static String[] separateDate(String date) {
        String[] splitted = date.split("/");
        int daysMonthYear = 3;
        if (splitted.length != daysMonthYear) {
            throw new IllegalArgumentException("La fecha debe tener formato dd/mm/yyyy");
        }
        return splitted;
    }
}
