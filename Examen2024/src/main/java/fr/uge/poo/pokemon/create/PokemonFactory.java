package fr.uge.poo.pokemon.create;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class PokemonFactory {
    private long currentId;
    private final Set<String> registeredNamePokemon = new HashSet<String>();

    public PokemonUnique createUniquePokemon(String name, int strength, int defense, int hitPoints){
        PokemonUnique pokemon = null;
        if(registeredNamePokemon.add(name)) {
            currentId++;
            pokemon = new PokemonUnique(name, strength, defense, hitPoints);
        }else{
            throw new IllegalArgumentException("Pokemon already exists");
        }
        return pokemon;
    }

//    public Optional<PokemonUnique> getStudentById(long id){
//        return Optional.ofNullable(registeredPokemon.get(id));
//    }
}
