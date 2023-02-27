package model.pokemon;

import model.type.TypeWater;

public class WaterPokemon extends Pokemon {
    public WaterPokemon(String name, Stats stats) {
        super(name, new TypeWater(), stats);
    }
}
