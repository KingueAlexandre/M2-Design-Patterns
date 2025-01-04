package fr.uge.poo.pokemon.retrieve;

import com.pokedex.Pokedex;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AdapterPokedex implements PokeInterface{
    private final Pokedex pokedex = new Pokedex();

    @Override
    public void printAllPokemonNames() {
        System.out.println(pokedex.names().stream().map(String::toString).collect(Collectors.joining(", ","",".")));
    }

    @Override
    public void queryPokemonInfo(String name) {
        var statsNames = List.of("strength","defense","hitPoints");
        var stats = pokedex.statistics(name);
        if(stats != null) {
            System.out.println(
                    "fr.uge.poo.pokemon.create.Pokemon{name='"+name+"' " +
                    IntStream.range(0, stats.size())
                            .mapToObj(i-> String.valueOf(stats.get(i)) + "=" + statsNames.get(i))
                            .collect(Collectors.joining(", ")) +
                    "}"
            );
        }else{
            System.out.println("Unknow fr.uge.poo.pokemon.create.Pokemon " + name);
        }

    }
}
