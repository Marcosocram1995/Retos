package model.pokemon;

import model.type.TypePlant;

public class PlantPokemon extends Pokemon {
    public PlantPokemon(String name, Stats stats) {
        super(name, new TypePlant(), stats);
    }
}
