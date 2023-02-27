package model.battle.turn;

import model.battle.Observer;
import model.pokemon.Pokemon;

public class Turn {
    private final AiTurn aiTurn;
    private final UserTurn userTurn;

    protected Turn(Pokemon userPokemon, Pokemon aiPokemon, Observer observer) {
        userTurn = new UserTurn(userPokemon, aiPokemon);
        aiTurn = new AiTurn(userPokemon, aiPokemon);
        registerObserver(userTurn, observer);
        registerObserver(aiTurn, observer);
    }

    protected UserTurn getUserTurn() {
        return this.userTurn;
    }

    protected AiTurn getAiTurn() {
        return this.aiTurn;
    }

    private void registerObserver(TurnAbstract turn, Observer observer) {
        turn.registerObserver(observer);
    }
}
