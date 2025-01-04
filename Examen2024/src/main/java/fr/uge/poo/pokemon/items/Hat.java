package fr.uge.poo.pokemon.items;

public class Hat implements Equipement{

    private final int defUp;

    public Hat(int defUp) {
        if (defUp < 0){
            throw new IllegalArgumentException("stat < 0");
        }
        this.defUp = defUp;
    }


    @Override
    public int newStat(int stat) {
        return stat + defUp;
    }

    @Override
    public TypeEquip type() {
        return TypeEquip.DEFENSE;
    }

    @Override
    public PokemonInterface equip(PokemonInterface pokemon) {
        return new PokemonInterface() {
            @Override
            public String name() {
                return pokemon.name();
            }

            @Override
            public int strength() {
                return pokemon.strength();
            }

            @Override
            public int defense() {
                return pokemon.defense()*defUp;
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
