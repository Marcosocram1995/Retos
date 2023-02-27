package model.movement;

import model.type.Type;

public abstract class Movement {
    private final String name;
    private final int power;
    private final Type type;

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public Type getType() {
        return type;
    }

    protected Movement(String name, int power, Type type) {
        this.name = name;
        this.power = power;
        this.type = type;
    }
}