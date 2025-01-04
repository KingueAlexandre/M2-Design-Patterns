package fr.uge.poo.pokemon.arena;

import fr.uge.poo.pokemon.arena.Pokemon;

import java.util.ArrayList;

public interface MainObserver {
    void startFight(ArrayList<Pokemon> pokemons);
    void deadPokemon(Pokemon pokemon);
    void endFight(String resume);
}
