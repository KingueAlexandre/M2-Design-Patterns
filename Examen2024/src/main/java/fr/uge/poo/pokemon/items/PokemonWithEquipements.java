package fr.uge.poo.pokemon.items;

//Decorateur (1er Solution: Met trop de temps / Plus compliqué)

import java.util.*;

public class PokemonWithEquipements implements PokemonInterface{
    private final PokemonInterface pokemon;
    private final Map<Equipement.TypeEquip,List<Equipement>> mapEquip = new HashMap<Equipement.TypeEquip,List<Equipement>>();

    public PokemonWithEquipements(String name, int strength, int defense, int hitPoints) {
        pokemon = new Pokemon(name, strength, defense, hitPoints);
    }

    public void attachEquip(Equipement equip) {
        if(mapEquip.containsKey(equip.type())){
            var lst = mapEquip.get(equip.type());
            lst.add(equip);
            mapEquip.put(equip.type(), lst);
        }else{
            mapEquip.put(equip.type(),new ArrayList<>(List.of(equip)));
        }
    }

    @Override
    public String name() {
        return pokemon.name();
    }

    @Override
    public int strength() {
        if(mapEquip.containsKey(Equipement.TypeEquip.STRENGHT)){
            var lst = mapEquip.get(Equipement.TypeEquip.STRENGHT);
            return lst.stream().reduce(pokemon.strength(),
                    (n,equip) -> equip.newStat(n),
                    (a,b) -> b);
        }
        return pokemon.strength();
    }

    @Override
    public int defense() {
        if(mapEquip.containsKey(Equipement.TypeEquip.DEFENSE)){
            var lst = mapEquip.get(Equipement.TypeEquip.DEFENSE);
            return lst.stream().reduce(pokemon.defense(),
                    (n,equip) -> equip.newStat(n),
                    (a,b) -> b);
        }
        return pokemon.defense();
    }

    @Override
    public int hitPoints() {
        return pokemon.hitPoints();
    }

    @Override
    public boolean isAlive() {
        return pokemon.isAlive();
    }

    @Override
    public void damage(int amount) {
        pokemon.damage(amount);
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + pokemon.name() + '\'' +
                ", strength=" + this.strength() +
                ", defense=" + this.defense() +
                ", hitPoints=" + this.hitPoints() +
                '}';
    }

}
