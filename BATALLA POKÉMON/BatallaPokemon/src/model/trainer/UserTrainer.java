package model.trainer;

import model.pokemon.Pokemon;

import java.util.List;

public class UserTrainer {
    private final String name;
    private final List<Pokemon> pokemonList;

    public String getName() {
        return name;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public UserTrainer(String name, List<Pokemon> pokemonList) {
        this.name = name;
        this.pokemonList = pokemonList;
    }
}
