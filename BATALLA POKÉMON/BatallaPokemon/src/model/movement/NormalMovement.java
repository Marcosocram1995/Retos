package model.movement;

import model.type.TypeNormal;

public class NormalMovement extends Movement {
    public NormalMovement(String name, int power) {
        super(name, power, new TypeNormal());
    }
}

