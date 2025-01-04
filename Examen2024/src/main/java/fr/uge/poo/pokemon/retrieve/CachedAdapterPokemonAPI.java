package fr.uge.poo.pokemon.retrieve;

import com.pokemonapi.PokemonAPI;

import java.util.HashSet;
import java.util.Set;

//Decorateur


public class CachedAdapterPokemonAPI implements PokeInterface{
    private final AdapterPokemonAPI adapterPokemonAPI = new AdapterPokemonAPI();
    private final Set<String> cacheNames = new HashSet<String>();

    @Override
    public void printAllPokemonNames() {
        adapterPokemonAPI.printAllPokemonNames();
    }

    @Override
    public void queryPokemonInfo(String name) {
        if(cacheNames.add(name)){
            adapterPokemonAPI.queryPokemonInfo(name);
        }else{
            System.out.println("Pas de double acces à " + name);
        }
    }
}
