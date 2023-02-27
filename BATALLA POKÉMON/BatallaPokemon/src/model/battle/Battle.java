package model.battle;

import model.battle.turn.Subject;
import model.battle.turn.TurnInitializer;
import model.pokemon.Pokemon;
import model.printer.Printer;

public class Battle implements Observer {
    private final TurnInitializer turnInitializer;
    private Pokemon winner;
    private Pokemon loser;
    private final Printer printer;

    public Battle(Pokemon userPokemon, Pokemon aiPokemon) {
        this.turnInitializer = new TurnInitializer(userPokemon, aiPokemon, this);
        this.printer = new Printer();
    }

    public void start() {
        while (winner == null) {
            turnInitializer.nextTurn();
            this.start();
        }
        finish();
    }

    private void finish() {
        float exp = calculateExp(winner, loser);
        printer.printWinner(winner.getName());
        printer.printExpGained(exp);
        upLevel(exp);
        System.exit(0);
    }

    private void upLevel(float exp) {
        int initialLevel = winner.getLevel();
        winner.gainExp(exp);
        int actualLevel = winner.getLevel();
        if (actualLevel > initialLevel) {
            printer.printUppedLevel(actualLevel - initialLevel);
        }
    }

    private float calculateExp(Pokemon winner, Pokemon loser) {
        int expIncrementer = 30;
        int levelDifference = (loser.getLevel() - winner.getLevel()) + 1;
        for (int i = 0; i < levelDifference; i++) {
            expIncrementer += expIncrementer * 2;
        }
        return expIncrementer * 2.25f;
    }

    @Override
    public void update(Subject subject) {
        this.winner = subject.getWinner();
        this.loser = subject.getLoser();
    }
}
