package fr.uge.poo.pokemon.arena;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Observer;

public class TwitterObserver implements MainObserver {
    @Override
    public void startFight(ArrayList<Pokemon> pokemons) {

    }

    @Override
    public void deadPokemon(Pokemon pokemon) {
        System.out.println("Pokemon observer: pokemon dead");
        System.out.println("_______________________________");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH");
        System.out.println(pokemon.name() + " is dead at " + LocalDateTime.now().format(formatter));
        System.out.println("_______________________________");
    }

    @Override
    public void endFight(String resume) {

    }
}
