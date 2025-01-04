package fr.uge.poo.pokemon.retrieve;

import com.pokedex.Pokedex;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//Decorateur

public class CachedAdapterPokedex implements PokeInterface{
    private final AdapterPokedex adapterPokedex = new AdapterPokedex();
    private final Set<String> cacheNames = new HashSet<String>();

    @Override
    public void printAllPokemonNames() {
        adapterPokedex.printAllPokemonNames();
    }

    @Override
    public void queryPokemonInfo(String name) {
        if(cacheNames.add(name)){
            adapterPokedex.queryPokemonInfo(name);
        }else{
            System.out.println("Pas de double acces à " + name);
        }
    }
}
