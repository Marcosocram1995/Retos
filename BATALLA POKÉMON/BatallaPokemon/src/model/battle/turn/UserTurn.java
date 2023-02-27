package model.battle.turn;

import model.Effectiveness;
import model.movement.Movement;
import model.pokemon.Pokemon;

public class UserTurn extends TurnAbstract {
    protected UserTurn(Pokemon userPokemon, Pokemon aiPokemon) {
        super(userPokemon, aiPokemon);
    }

    @Override
    public void initialize() {
        printer.printScreen(userPokemon.getName(), aiPokemon.getName(), userPokemon.getMovementList());
        makeTurn(userPokemon, aiPokemon);
    }

    @Override
    public int generateAction() {
        int input;
        do {
            input = printer.getInputUser();
        } while (input <= 0 || input > userPokemon.getMovementList().size());
        return input - 1;
    }

    @Override
    public int calculate(Movement movement, Effectiveness effectiveness) {
        return damageCalculator.userAttack(movement, effectiveness);
    }

    @Override
    public Pokemon getWinner() {
        return userPokemon;
    }

    @Override
    public Pokemon getLoser() {
        return aiPokemon;
    }
}
