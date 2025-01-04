package fr.uge.poo.pokemon.scripts;

import fr.uge.poo.pokemon.items.Pokemon;
import fr.uge.poo.pokemon.items.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PokeScript {
    private final List<PokemonInterface> pokemons = new ArrayList<PokemonInterface>();
    private final List<Equipement> equipements = new ArrayList<Equipement>();
    public void fileToPokemons(String nameFile) throws IOException {
        Path path = Paths.get(nameFile);

        List<String> lines = Files.readAllLines(path);
        for (String line : lines) {
            String[] parts = line.split(";");
            if(parts[0].equals("ENCOUNTER_POKEMON")){
                pokemons.add(new Pokemon(parts[1],Integer.parseInt(parts[2]),Integer.parseInt(parts[3]),Integer.parseInt(parts[4])));
                System.out.println("Rencontre " + parts[1]);
            }else if (parts[0].equals("PICK_UP_ITEM")){
                if (parts[1].equals("HAT")){
                    equipements.add(new Hat(Integer.parseInt(parts[2])));
                }else if(parts[1].equals("SHIELD")){
                    equipements.add(new Shield(Integer.parseInt(parts[2])));
                } else if (parts[1].equals("SWORD")) {
                    equipements.add(new Sword(Integer.parseInt(parts[2])));
                }
                System.out.println("Récupère l'item " + parts[1] +  " (" + parts[2] + ")");
            }else if (parts[0].equals("EQUIP_ITEM")){
                Equipement equipement = null;
                if (parts[1].equals("HAT")){
                    equipement = new Hat(Integer.parseInt(parts[2]));
                }else if(parts[1].equals("SHIELD")){
                    equipement = new Shield(Integer.parseInt(parts[2]));
                } else if (parts[1].equals("SWORD")) {
                    equipement = new Sword(Integer.parseInt(parts[2]));
                }
                if (equipement != null && equipements.contains(equipement)) {
                    var pokemon = pokemons.removeLast();
                    if(pokemon != null){
                        pokemons.add(equipement.equip(pokemon));
                        System.out.println("Equipe l'item " + parts[1] +  " (" + parts[2] + ") à " + pokemon.name());
                    }
                }
            }

        }

    }
}
