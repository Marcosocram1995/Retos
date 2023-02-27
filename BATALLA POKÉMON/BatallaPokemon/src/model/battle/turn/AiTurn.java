package model.battle.turn;

import model.Effectiveness;
import model.movement.Movement;
import model.pokemon.Pokemon;

import java.util.Random;

public class AiTurn extends TurnAbstract {
    private final Random random;

    protected AiTurn(Pokemon userPokemon, Pokemon aiPokemon) {
        super(userPokemon, aiPokemon);
        this.random = new Random();
    }

    @Override
    public void initialize() {
        makeTurn(aiPokemon, userPokemon);
    }

    @Override
    public int generateAction() {
        return random.nextInt(aiPokemon.getMovementList().size());
    }

    @Override
    public int calculate(Movement movement, Effectiveness effectiveness) {
        return damageCalculator.aiAttack(movement, effectiveness);
    }

    @Override
    public Pokemon getWinner() {
        return aiPokemon;
    }

    @Override
    public Pokemon getLoser() {
        return userPokemon;
    }
}
