package fr.uge.poo.pokemon.arena;

import fr.uge.poo.pokemon.create.PokemonUnique;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;

public class Arena {

    private final ArrayList<Pokemon> fighters = new ArrayList<>();
    private final SelectionStrategy strategy;
    private final List<MainObserver> observers = new ArrayList<>();


    public Arena(List<Pokemon> pokemons, SelectionStrategy strategy) {
        Objects.requireNonNull(pokemons);
        Objects.requireNonNull(strategy);
        for(var pokemon : pokemons){
            Objects.requireNonNull(pokemon);
            if (!pokemon.isAlive()){
                throw new IllegalArgumentException("All pokemon entering the arena must be alive");
            }
            fighters.add(pokemon);
        }
        this.strategy = strategy;
    }

    public Pokemon winner(){
        if (fighters.size()!=1){
            throw new IllegalStateException("A winner has not yet been crowned");
        }
        return fighters.iterator().next();
    }

    public void startFight(){
        var rng = ThreadLocalRandom.current();
        StringBuilder builder = new StringBuilder();
        this.startFightObserved();
        while(fighters.size()!=1){
            Pokemon[] pokemonRes = strategy.select(fighters);
            var attacker = pokemonRes[0];
            var defender = pokemonRes[1];
//            System.out.println(attacker + " " + defender);
            if (attacker==defender){
                continue;
            }
            builder.append(attacker).append(" attacks ").append(defender).append("\n");
            System.out.println(attacker.name() + " attacks " + defender.name());
            Pokemon.attack(attacker,defender);
            if (!defender.isAlive()){
                this.deadPokemonObserved(defender);
                System.out.println(defender + " died :(");
                fighters.remove(defender);
            }
        }
        System.out.println("Combat is finished. The winner is "+winner());
        this.endFightObserved(builder.toString());
    }


    private void startFightObserved(){
        observers.forEach(observer -> observer.startFight(fighters));
    }

    private void deadPokemonObserved(Pokemon defeated){
        observers.forEach(observer -> observer.deadPokemon(defeated));
    }

    private void endFightObserved(String resume){
        observers.forEach(observer -> observer.endFight(resume));
    }




    private void registerObserver(MainObserver observer){
        Objects.requireNonNull(observer);
        observers.add(observer);
    }

    public static void main(String[] args) {
////        SelectionStrategy strategyR = new RandomStrategy();
//        SelectionStrategy strategyH = new HitPointsStrategy();
////        var arenaR = new Arena(List.of(new Pokemon("Ronflex",10,100,4),new Pokemon("Miaouss",1,10,10),new Pokemon("Bulbizar",5,5,8)),strategyR);
//        var arenaH = new Arena(List.of(new Pokemon("Ronflex",10,100,4),new Pokemon("Miaouss",1,10,10),new Pokemon("Bulbizar",5,5,8)),strategyH);
////        arenaR.startFight();
//        arenaH.startFight();
        MainObserver observerMail = new MailObserver();
        MainObserver observerTwitter = new TwitterObserver();
        MainObserver observerFacebook = new FacebookObserver();
        var arena = new Arena(List.of(new Pokemon("Ronflex",10,100,4),new Pokemon("Miaouss",1,10,10),new Pokemon("Bulbizar",5,5,8)), new RandomStrategy());
        arena.registerObserver(observerMail);
        arena.registerObserver(observerTwitter);
        arena.registerObserver(observerFacebook);
        arena.startFight();
    }
}
