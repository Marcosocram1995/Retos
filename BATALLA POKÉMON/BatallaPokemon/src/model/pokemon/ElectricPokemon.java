package model.pokemon;

import model.type.TypeElectric;

public class ElectricPokemon extends Pokemon {
    public ElectricPokemon(String name, Stats stats) {
        super(name, new TypeElectric(), stats);
    }
}
