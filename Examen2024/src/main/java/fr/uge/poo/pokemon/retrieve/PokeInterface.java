package fr.uge.poo.pokemon.retrieve;

import java.util.List;

public interface PokeInterface {
    void printAllPokemonNames();
    void queryPokemonInfo(String name);
    static int APPELS_RESTANTS = 1000;
}
