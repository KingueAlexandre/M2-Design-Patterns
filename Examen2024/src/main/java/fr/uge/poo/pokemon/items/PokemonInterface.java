package fr.uge.poo.pokemon.items;

public interface PokemonInterface {
    public String name();

    public int strength();

    public int defense();

    public int hitPoints();

    public boolean isAlive();

    public void damage(int amount);
}
