package fr.uge.poo.pokemon.items;

public interface Equipement {
    /*Solution 1*/
    int newStat(int stat);
    TypeEquip type();
    enum TypeEquip{
        STRENGHT,
        DEFENSE
    }
    /*Solution 2*/
    PokemonInterface equip(PokemonInterface pokemon);
}
