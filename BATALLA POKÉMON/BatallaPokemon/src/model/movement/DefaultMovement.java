package model.movement;

public interface DefaultMovement {
    static Movement getPlacaje() {
        return new NormalMovement("Placaje", 10);
    }
}
