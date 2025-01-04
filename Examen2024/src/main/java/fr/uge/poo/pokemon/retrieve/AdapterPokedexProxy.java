package fr.uge.poo.pokemon.retrieve;

import com.pokedex.Pokedex;

import java.util.HashSet;
import java.util.Set;

//Adapter

public class AdapterPokedexProxy implements PokeInterface{
    private final AdapterPokemonAPI adapterPokemonAPI = new AdapterPokemonAPI();

    @Override
    public void printAllPokemonNames() {
        adapterPokemonAPI.printAllPokemonNames();
    }

    @Override
    public void queryPokemonInfo(String name) {
        if(APPELS_RESTANTS > 0){
            //this.APPELS_RESTANTS = APPELS_RESTANTS - 1;
            adapterPokemonAPI.queryPokemonInfo(name);
        }else{
            System.out.println("Pas de double acces à " + name);
        }
    }
}
