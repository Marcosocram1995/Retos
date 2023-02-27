package model.pokemon;

public class Level {
    private int number;
    private float actualExp;
    private int necessaryExp;

    protected int getNumber() {
        return number;
    }

    protected void setNumber(int number) {
        this.number = number;
        necessaryExp = calculateNecessaryExp();
    }

    protected void gainExp(float exp, Stats stats) {
        actualExp += exp;
        while (actualExp >= necessaryExp) {
            actualExp -= necessaryExp;
            upLevel();
            stats.uploadStats(number);
        }
    }

    private void upLevel() {
        setNumber(number + 1);
    }

    private int calculateNecessaryExp() {
        return 100 * (number * 2);
    }

    protected Level() {
        setNumber(1);
        this.actualExp = 0;
    }
}
