package model.battle.turn;

import model.Effectiveness;
import model.battle.Observer;
import model.battle.damage.CalculateDamage;
import model.battle.damage.DamageCalculator;
import model.movement.Movement;
import model.pokemon.Pokemon;
import model.printer.Printer;

public abstract class TurnAbstract implements GenerateAction, Initializable, CalculateDamage, Subject {
    protected DamageCalculator damageCalculator;

    protected Pokemon userPokemon;
    protected Pokemon aiPokemon;
    protected Printer printer;
    protected Observer observer;

    protected TurnAbstract(Pokemon userPokemon, Pokemon aiPokemon) {
        this.damageCalculator = new DamageCalculator(userPokemon.getStats(), aiPokemon.getStats());
        this.userPokemon = userPokemon;
        this.aiPokemon = aiPokemon;
        this.printer = new Printer();
    }

    protected void makeTurn(Pokemon attacker, Pokemon defender) {
        int input = generateAction();
        Movement movement = attacker.getMovementList().get(input);
        Effectiveness effectiveness = getEffectiveness(movement, defender);
        int damage = calculate(movement, effectiveness);
        defender.hit(damage);
        printer.printMovement(attacker.getName(), movement.getName());
        printer.printDamage(damage);
        if (damageCalculator.isCriticDamage()) {
            printer.printCritic();
        }
        printer.printEffectiveness(effectiveness);
        printer.printHealth(defender.getName(), defender.getStats().getHealth());
        if (defender.getStats().getHealth() <= 0) {
            notifyObservers();
        }
    }

    private Effectiveness getEffectiveness(Movement movement, Pokemon defender) {
        return Effectiveness.calculateEffectiveness(movement.getType(), defender.getType());
    }

    @Override
    public void registerObserver(Observer observer) {
        this.observer = observer;
    }

    @Override
    public void notifyObservers() {
        observer.update(this);
    }
}
