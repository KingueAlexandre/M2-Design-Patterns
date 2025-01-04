package fr.uge.poo.pokemon.arena;

import fr.uge.poo.pokemon.arena.Pokemon;

import java.util.List;
import java.util.Random;

public class RandomStrategy implements SelectionStrategy {
    private final Random rand = new Random();

    @Override
    public Pokemon[] select(List<Pokemon> pokemons) {
        if (pokemons.size() < 2) {
            return null;
        }
        var att = pokemons.get(rand.nextInt(pokemons.size()));
        var def = pokemons.get(rand.nextInt(pokemons.size()));

        do {
            def = pokemons.get(rand.nextInt(pokemons.size()));
        }while(def == att);

        return new Pokemon[]{att,def};
    }
}
