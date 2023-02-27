package model.pokemon;

import model.type.TypeFire;

public class FirePokemon extends Pokemon {
    public FirePokemon(String name, Stats stats) {
        super(name, new TypeFire(), stats);
    }
}
