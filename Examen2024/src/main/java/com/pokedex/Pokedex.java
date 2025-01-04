package com.pokedex;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Pokedex {

    private static final Map<String,List<Integer>> pokemons = Map.of("Pikachu",List.of(5,10,100),"Ronflex",List.of(100,100,500),"Bulbizar",List.of(10,20,600));

    /**
     * Retrieve the list of all fr.uge.poo.pokemon.create.Pokemon names
     */
    public List<String> names(){
        return pokemons.keySet().stream().toList();
    }

    /**
     * Return a list of integer containing the strength, defense and hitpoints of the fr.uge.poo.pokemon.create.Pokemon or null if there is no fr.uge.poo.pokemon.create.Pokemon with this name
     * @param name
     * @return null if there is no fr.uge.poo.pokemon.create.Pokemon with this name
     */
    public List<Integer> statistics(String name){
        Objects.requireNonNull(name);
        return pokemons.get(name);
    }

}
