package model.battle.damage;

import model.Effectiveness;
import model.movement.Movement;
import model.pokemon.Stats;

import java.util.Random;

public class DamageCalculator {
    private final Stats userPokemonStats;
    private final Stats aiPokemonStats;
    private static final int MINIMUM_DAMAGE = 2;
    private static final int CRITIC_DAMAGE = 7;
    private final Random random;
    private boolean criticDamage;
    public boolean isCriticDamage() {
        return criticDamage;
    }

    public DamageCalculator(Stats userPokemonStats, Stats aiPokemonStats) {
        this.userPokemonStats = userPokemonStats;
        this.aiPokemonStats = aiPokemonStats;
        this.random = new Random();
    }

    public int userAttack(Movement movement, Effectiveness effectiveness) {
        return attack(movement, effectiveness, userPokemonStats, aiPokemonStats);
    }

    public int aiAttack(Movement movement, Effectiveness effectiveness) {
        return attack(movement, effectiveness, aiPokemonStats, userPokemonStats);
    }

    private int attack(Movement movement, Effectiveness effectiveness, Stats attacker, Stats defender) {
        int attackValue = movement.getPower() + attacker.getBaseAttack();
        int damage = attackValue - defender.getBaseDefense();
        float multiplier = effectiveness.getMultiplier();
        int critic = getCritic();
        damage = Math.round(damage * multiplier);
        damage += critic;
        if (damage < MINIMUM_DAMAGE) {
            damage = MINIMUM_DAMAGE;
        }
        return damage;
    }

    private int getCritic() {
        criticDamage = false;
        int critic = random.nextInt(5) + random.nextInt(5);
        if (critic >= CRITIC_DAMAGE) {
            criticDamage = true;
        }
        return critic;
    }
}
