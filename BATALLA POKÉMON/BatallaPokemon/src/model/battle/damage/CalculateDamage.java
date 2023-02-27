package model.battle.damage;

import model.Effectiveness;
import model.movement.Movement;

public interface CalculateDamage {
    int calculate(Movement movement, Effectiveness effectiveness);
}
