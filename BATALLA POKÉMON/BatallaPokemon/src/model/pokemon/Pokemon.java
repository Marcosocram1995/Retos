package model.pokemon;

import model.movement.DefaultMovement;
import model.movement.Movement;
import model.type.Type;
import model.type.TypeNormal;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Pokemon {
    private final String name;
    private final Type type;
    private final Level level;
    private final Stats stats;
    private final List<Movement> movementList;

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public Stats getStats() {
        return stats;
    }

    public int getLevel() {
        return level.getNumber();
    }

    public List<Movement> getMovementList() {
        return movementList;
    }

    public void setLevel(int level) {
        this.level.setNumber(level);
        this.stats.uploadStats(level);
    }

    public void addMovement(Movement movement) {
        if (Objects.equals(movement.getType().getName(), type.getName()) || Objects.equals(movement.getType().getName(), TypeNormal.NAME))
            movementList.add(movement);
    }

    public void gainExp(float exp) {
        level.gainExp(exp, stats);
    }

    public void hit(int damage) {
        stats.hit(damage);
    }

    protected Pokemon(String name, Type type, Stats stats) {
        this.name = name;
        this.type = type;
        this.stats = stats;
        this.level = new Level();
        this.movementList = new ArrayList<>(List.of(DefaultMovement.getPlacaje()));
    }
}
