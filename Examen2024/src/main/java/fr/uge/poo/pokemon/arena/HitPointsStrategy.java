package fr.uge.poo.pokemon.arena;

import fr.uge.poo.pokemon.arena.Pokemon;

import java.util.Comparator;
import java.util.List;

public class HitPointsStrategy implements SelectionStrategy {
    @Override
    public Pokemon[] select(List<Pokemon> pokemons) {
        if (pokemons.size() < 2){
            return null;
        }
        var lst = pokemons.stream().sorted(Comparator.comparingInt(Pokemon::hitPoints)).toList();
        var att = lst.getFirst();
        var def = lst.getLast();
        return new Pokemon[]{att, def};
    }
}
