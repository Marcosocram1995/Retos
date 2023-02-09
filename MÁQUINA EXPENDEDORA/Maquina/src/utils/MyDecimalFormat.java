package utils;

import java.text.DecimalFormat;

public class MyDecimalFormat {
    private String number;

    public String getNumberString() {
        return number;
    }

    public float getNumberFloat() {
        String string = this.number;
        string = string.replace(",", ".");
        return Float.parseFloat(string);
    }


    public MyDecimalFormat(int howManyDecimals, float number) {
        if (howManyDecimals > 0) {
            StringBuilder pattern = new StringBuilder("0.");
            String string = "0";

            pattern.append(string.repeat(howManyDecimals));

            DecimalFormat dfrmt = new java.text.DecimalFormat((pattern.toString()));
            this.number = dfrmt.format(number);
        }
    }
}
