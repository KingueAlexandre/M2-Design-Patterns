package fr.uge.poo.pokemon.retrieve;

import com.pokemonapi.PokemonAPI;

import java.util.Arrays;
import java.util.Scanner;

//2. Implémentez l'évolution demandée. En commentaire en haut du fichier PokeRetriever, donnez le nom du design pattern
// que vous avez utilisé.
// Adapter

//3. Implémentez l'évolution demandée. En commentaire en haut du fichier PokeRetriever, donnez le nom du design pattern
// que vous avez utilisé.
// Decorateur

public class PokeRetriever {

    private final PokeInterface poke;

    private final Scanner scanner = new Scanner(System.in);

    public PokeRetriever(boolean pokeApi, boolean cached) {
        if(pokeApi){
            if(!cached){
                poke = new AdapterPokemonAPI();
            }else{
                poke = new CachedAdapterPokemonAPI();
            }
        }else{
            if(!cached){
                poke = new AdapterPokedex();
            }else{
                poke = new CachedAdapterPokedex();
            }
        }
    }

    private void usage() {
        System.out.println("1. Print the list of all pokémon names");
        System.out.println("2. Detailed info on a pokémon");
    }

    private void printAllPokemonNames() {
        poke.printAllPokemonNames();
    }

    public void launch() {
        usage();
        while (scanner.hasNextLine()){
            var cmd = scanner.nextLine();
            switch (cmd) {
                case "1" -> printAllPokemonNames();
                case "2" -> queryPokemonInfo();
                default -> System.out.println("Unrecognized command "+ cmd);
            }
            usage();
        }

    }

    private void queryPokemonInfo() {
        System.out.println("Enter the name of your fr.uge.poo.pokemon.create.Pokemon :");
        var name = scanner.nextLine();
        poke.queryPokemonInfo(name);
    }

    public static void main(String[] args) {
        if(Arrays.stream(args).toList().contains("--pokedex")){
            if(Arrays.stream(args).toList().contains("--cache")){
                new PokeRetriever(false,true).launch();
            }else{
                new PokeRetriever(false,false).launch();
            }
        }else {
            if(Arrays.stream(args).toList().contains("--cache")){
                new PokeRetriever(true,true).launch();
            }else{
                new PokeRetriever(true,false).launch();
            }
        }
    }
}
