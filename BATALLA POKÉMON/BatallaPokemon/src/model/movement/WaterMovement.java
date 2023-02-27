package model.movement;

import model.type.TypeWater;

public class WaterMovement extends Movement {
    public WaterMovement(String name, int power) {
        super(name, power, new TypeWater());
    }
}