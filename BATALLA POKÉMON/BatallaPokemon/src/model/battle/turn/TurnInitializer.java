package model.battle.turn;

import model.battle.Observer;
import model.pokemon.Pokemon;

public class TurnInitializer {
    private int number;
    private final Turn turn;

    public TurnInitializer(Pokemon userPokemon, Pokemon aiPokemon, Observer observer) {
        this.number = 1;
        this.turn = new Turn(userPokemon, aiPokemon, observer);
    }

    public void nextTurn() {
        TurnAbstract abstractTurn = this.turn.getUserTurn();
        if (number % 2 == 0) {
            abstractTurn = this.turn.getAiTurn();
        }
        number++;
        abstractTurn.initialize();
    }
}
