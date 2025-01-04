package fr.uge.poo.pokemon.items;

public class Application {
    public static void main(String[] args) {
        var pokemon1 = new PokemonWithEquipements("Bob",5,10,200);
        var hat1 = new Hat(5);
        var shield1 = new Shield(2);
        var sword1 = new Sword(7);
        
        System.out.println(pokemon1.toString());
        var pokemon2 = hat1.equip(pokemon1);
        System.out.println(pokemon2.toString());
        var pokemon3 = shield1.equip(pokemon2);
        System.out.println(pokemon3.toString());
        var pokemon4 = sword1.equip(pokemon2);
        System.out.println(pokemon4.toString());

        System.out.println(pokemon1.toString());
        pokemon1.attachEquip(shield1);
        pokemon1.attachEquip(hat1);
        pokemon1.attachEquip(sword1);
        System.out.println(pokemon1.toString());

    }
}
