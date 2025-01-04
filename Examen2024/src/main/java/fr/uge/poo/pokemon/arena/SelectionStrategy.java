package fr.uge.poo.pokemon.arena;

import fr.uge.poo.pokemon.arena.Pokemon;

import java.util.List;

public interface SelectionStrategy {
    Pokemon[] select(List<Pokemon> pokemons);
}
