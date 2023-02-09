package model.money;

public enum Coin {
    ONECENT(0.01f), TWOCENT(0.02f), FIVECENT(0.05f), TENCENT(0.1f), TWENTYCENTS(0.2f), FIFTYCENT(0.5f), ONEEURO(1), TWOEURO(2);
    private final float value;

    public float getValue() {
        return value;
    }

    Coin(float value) {
        this.value = value;
    }

}
