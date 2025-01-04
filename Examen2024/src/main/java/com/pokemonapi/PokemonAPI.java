package com.pokemonapi;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PokemonAPI {

    private static final Map<Integer,List<Object>> pokemons = Map.of(1,List.of("Pikachu",5,10,100),2,List.of("Ronflex",100,100,500),13,List.of("Bulbizar",10,20,600));

    /**
     * Retrieve the list of ids of all Pokemons
     */
    public List<Integer> allIds(){
        return pokemons.keySet().stream().toList();
    }

    /**
     * Return the id corresponding to a name if it exists
     * @param name
     * @return null if there is no fr.uge.poo.pokemon.create.Pokemon with this id
     */
    public Integer idFromName(String name){
        Objects.requireNonNull(name);
        for(var entry : pokemons.entrySet()){
            if (entry.getValue().get(0).equals(name)) {
                return entry.getKey();
            }
        }
        return null;
    }

    /**
     * Return the name of the fr.uge.poo.pokemon.create.Pokemon with a given id or null if no fr.uge.poo.pokemon.create.Pokemon exists with this id
     */
    public String nameFromId(int id){
        var list = pokemons.get(id);
        return list == null ? null : (String) list.get(0);
    }

    /**
     * Return the strength of the fr.uge.poo.pokemon.create.Pokemon with a given id or null if no fr.uge.poo.pokemon.create.Pokemon exists with this id
     */
    public Integer strengthFromId(int id){
        var list = pokemons.get(id);
        return list == null ? null : (Integer) list.get(1);
    }

    /**
     * Return the defense of the fr.uge.poo.pokemon.create.Pokemon with a given id or null if no fr.uge.poo.pokemon.create.Pokemon exists with this id
     */
    public Integer defenseFromId(int id){
        var list = pokemons.get(id);
        return list == null ? null : (Integer) list.get(2);
    }

    /**
     * Return the hitPoints of the fr.uge.poo.pokemon.create.Pokemon with a given id or null if no fr.uge.poo.pokemon.create.Pokemon exists with this id
     */

    public Integer hitPointsFromId(int id){
        var list = pokemons.get(id);
        return list == null ? null : (Integer) list.get(3);
    }
}
