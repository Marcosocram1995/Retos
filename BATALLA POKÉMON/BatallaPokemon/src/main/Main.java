package main;

import model.battle.Battle;
import model.movement.ElectricMovement;
import model.movement.WaterMovement;
import model.pokemon.ElectricPokemon;
import model.pokemon.Pokemon;
import model.pokemon.Stats;
import model.pokemon.WaterPokemon;

public class Main {
    public static void main(String[] args) {
        Pokemon pikachu = new ElectricPokemon("Pikachu", new Stats(50, 30, 10));
        Pokemon squirtle = new WaterPokemon("Squirtle", new Stats(60, 15, 20));
        pikachu.addMovement(new ElectricMovement("Impactrueno", 30));
        squirtle.addMovement(new WaterMovement("Chorrito de Agua", 20));

        new Battle(pikachu, squirtle).start();
    }
}