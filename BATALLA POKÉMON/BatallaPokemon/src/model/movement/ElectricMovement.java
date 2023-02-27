package model.movement;

import model.type.TypeElectric;

public class ElectricMovement extends Movement {
    public ElectricMovement(String name, int power) {
        super(name, power, new TypeElectric());
    }
}