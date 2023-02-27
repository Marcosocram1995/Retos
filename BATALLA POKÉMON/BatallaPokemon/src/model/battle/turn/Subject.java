package model.battle.turn;

import model.battle.Observer;
import model.pokemon.Pokemon;

public interface Subject {
    void registerObserver(Observer observer);

    void notifyObservers();

    Pokemon getWinner();

    Pokemon getLoser();
}
