package fr.uge.poo.pokemon.items;


import java.util.Objects;

public class Pokemon implements PokemonInterface{

    private final String name;

    private final int strength;

    private final int defense;

    private int hitPoints;


    public Pokemon(String name, int strength, int defense, int hitPoints)  {
        this.name = Objects.requireNonNull(name);
        if (strength<=0){
            throw new IllegalArgumentException("Strength must be strictly positive");
        }
        this.strength = strength;
        if (defense<=0){
            throw new IllegalArgumentException("Defense must be strictly positive");
        }
        this.defense = defense;
        if (hitPoints<=0){
            throw new IllegalArgumentException("HitPoints must be strictly positive");
        }
        this.hitPoints = hitPoints;
    }

    @Override
    public String name(){
        return name;
    }

    @Override
    public int strength() {
        return strength;
    }

    @Override
    public int defense() {
        return defense;
    }

    @Override
    public int hitPoints() {
        return hitPoints;
    }

    @Override
    public boolean isAlive() {
        return hitPoints != 0;
    }

    @Override
    public void damage(int amount){
        if (amount<0) {
            throw new IllegalArgumentException("Damage amount must be positive");
        }
        hitPoints = Math.max(hitPoints-amount, 0);
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", strength=" + strength +
                ", defense=" + defense +
                ", hitPoints=" + hitPoints +
                '}';
    }

    static void attack(Pokemon attacker, Pokemon defender){
        if (!attacker.isAlive() || !defender.isAlive()){
            throw new IllegalArgumentException("Both defender and attacker need to be alive");
        }
        defender.damage(Math.max(1, attacker.strength()-defender.defense()));
    }

}
