package model.movement;

import model.type.TypeFire;

public class FireMovement extends Movement {
    public FireMovement(String name, int power) {
        super(name, power, new TypeFire());
    }
}