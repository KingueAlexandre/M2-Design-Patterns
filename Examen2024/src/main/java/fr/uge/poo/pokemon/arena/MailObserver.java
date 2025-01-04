package fr.uge.poo.pokemon.arena;

import fr.uge.poo.pokemon.arena.Pokemon;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observer;
import java.util.stream.Collectors;

public class MailObserver implements MainObserver {

    @Override
    public void startFight(ArrayList<Pokemon> pokemons) {
        System.out.println("Pokemon observer: fight started");
        System.out.println("_______________________________");
        System.out.println(pokemons.stream().map(Pokemon::toString).collect(Collectors.joining("\n")));
        System.out.println("_______________________________");
    }

    @Override
    public void deadPokemon(Pokemon pokemon) {

    }

    @Override
    public void endFight(String resume) {

    }
}
