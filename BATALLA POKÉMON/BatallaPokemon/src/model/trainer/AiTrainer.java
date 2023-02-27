package model.trainer;

import model.pokemon.Pokemon;

import java.util.List;

public class AiTrainer extends UserTrainer {
    private final String introductorySentence;

    public String getIntroductorySentence() {
        return introductorySentence;
    }

    public AiTrainer(String name, List<Pokemon> pokemonList, String introductorySentence) {
        super(name, pokemonList);
        this.introductorySentence = introductorySentence;
    }
}
