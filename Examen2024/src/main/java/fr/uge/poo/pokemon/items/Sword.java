package fr.uge.poo.pokemon.items;

public class Sword implements Equipement{
    private final int atkUp;

    public Sword(int atkUp) {
        if (atkUp < 0){
            throw new IllegalArgumentException("stat < 0");
        }
        this.atkUp = atkUp;
    }
    /*Solution 1*/
    @Override
    public int newStat(int stat) {
        return stat + atkUp;
    }
    @Override
    public TypeEquip type() {
        return TypeEquip.STRENGHT;
    }

    /*Solution 2*/
    @Override
    public PokemonInterface equip(PokemonInterface pokemon) {
        return new PokemonInterface() {
            @Override
            public String name() {
                return pokemon.name();
            }

            @Override
            public int strength() {
                return pokemon.strength() + atkUp;
            }

            @Override
            public int defense() {
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
            public String toString(){
                return "Pokemon{" +
                        "name='" + pokemon.name() + '\'' +
                        ", strength=" + strength() +
                        ", defense=" + defense() +
                        ", hitPoints=" + pokemon.hitPoints() +
                        '}';
            }
        };
    }
}
