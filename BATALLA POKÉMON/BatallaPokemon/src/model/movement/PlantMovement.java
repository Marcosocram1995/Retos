package model.movement;

import model.type.TypePlant;

public class PlantMovement extends Movement {
    public PlantMovement(String name, int power) {
        super(name, power, new TypePlant());
    }
}