package fr.uge.poo.pokemon.arena;

import java.util.ArrayList;

public class FacebookObserver implements MainObserver{
    @Override
    public void startFight(ArrayList<Pokemon> pokemons) {

    }

    @Override
    public void deadPokemon(Pokemon pokemon) {

    }

    @Override
    public void endFight(String resume) {
        System.out.println("Pokemon observer: fight ended");
        System.out.println("Resume : ");
        System.out.println("_______________________________");
        System.out.println(resume);
        System.out.println("_______________________________");
    }
}
