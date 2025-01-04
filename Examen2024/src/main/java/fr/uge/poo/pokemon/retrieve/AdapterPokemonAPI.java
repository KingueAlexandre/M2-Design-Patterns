package fr.uge.poo.pokemon.retrieve;

import com.pokemonapi.PokemonAPI;

//Adapter

public class AdapterPokemonAPI implements PokeInterface{
    private final PokemonAPI pokemonAPI = new PokemonAPI();

    @Override
    public void printAllPokemonNames() {
        var pokemonIds = pokemonAPI.allIds();
        var names = pokemonIds.stream().map(pokemonAPI::nameFromId).toList();
        System.out.println(names);
    }

    @Override
    public void queryPokemonInfo(String name) {
        var id = pokemonAPI.idFromName(name);
        if (id == null) {
            System.out.println("Unknow fr.uge.poo.pokemon.create.Pokemon " + name);
            return;
        }
        var defense = pokemonAPI.defenseFromId(id);
        var strength = pokemonAPI.strengthFromId(id);
        var hitPoints = pokemonAPI.hitPointsFromId(id);

        System.out.println("fr.uge.poo.pokemon.create.Pokemon{" +
                "name='" + name + '\'' +
                ", strength=" + strength +
                ", defense=" + defense +
                ", hitPoints=" + hitPoints +
                '}');
    }
}
