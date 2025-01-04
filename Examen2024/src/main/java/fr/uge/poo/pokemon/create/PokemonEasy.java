package fr.uge.poo.pokemon.create;

import java.util.Objects;

public class PokemonEasy {
    private final String name;
    private final int strength;
    private final int defense;
    private int hitPoints;


    public static class Step{
        public static NameBuilder newBuilder(){
            return new Builder();
        }
        public interface NameBuilder{
            StrengthBuilder name(String name);
        }
        public interface StrengthBuilder{
            DefenseBuilder strength(int strength);
        }
        public interface DefenseBuilder{
            HitPointsBuilder defense(int defense);
        }
        public interface HitPointsBuilder{
            FinalBuilder hitPoints(int hitPoints);
        }
        public interface FinalBuilder{
            PokemonEasy build();
        }
        public static class Builder implements NameBuilder, StrengthBuilder, DefenseBuilder, HitPointsBuilder, FinalBuilder{
            private String name;
            private int strength;
            private int defense;
            private int hitPoints;

            @Override
            public HitPointsBuilder defense(int defense) {
                this.defense = defense;
                return this;
            }
            @Override
            public Builder hitPoints(int hitPoints) {
                this.hitPoints = hitPoints;
                return this;
            }
            @Override
            public StrengthBuilder name(String name) {
                this.name = name;
                return this;
            }
            @Override
            public DefenseBuilder strength(int strength) {
                this.strength = strength;
                return this;
            }
            @Override
            public PokemonEasy build() {
                return new PokemonEasy(name, strength, defense, hitPoints);
            }
        }
    }

    private PokemonEasy(String name, int strength, int defense, int hitPoints)  {
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

    public String name(){
        return name;
    }

    public int strength() {
        return strength;
    }

    public int defense() {
        return defense;
    }

    public int hitPoints() {
        return hitPoints;
    }

    public boolean isAlive() {
        return hitPoints != 0;
    }

    public void damage(int amount){
        if (amount<0) {
            throw new IllegalArgumentException("Damage amount must be positive");
        }
        hitPoints = Math.max(hitPoints-amount, 0);
    }

    @Override
    public String toString() {
        return "fr.uge.poo.pokemon.create.Pokemon{" +
                "name='" + name + '\'' +
                ", strength=" + strength +
                ", defense=" + defense +
                ", hitPoints=" + hitPoints +
                '}';
    }

    public static void attack(PokemonEasy attacker, PokemonEasy defender){
        if (!attacker.isAlive() || !defender.isAlive()){
            throw new IllegalArgumentException("Both defender and attacker need to be alive");
        }
        defender.damage(Math.max(1, attacker.strength()-defender.defense()));
    }

    public static void main(String[] args) {
        var pokemon = PokemonEasy.Step.newBuilder().name("Pikachu").strength(150).defense(20).hitPoints(10).build();
        System.out.println(pokemon);
    }
}
