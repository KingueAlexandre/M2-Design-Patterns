package fr.uge.poo.amanet;

import fr.uge.poo.amanet.client.Client;
import fr.uge.poo.amanet.client.Client.Step;
import fr.uge.poo.amanet.client.Country;
import fr.uge.poo.amanet.inventory.Inventory;
import fr.uge.poo.amanet.inventory.NotificationService;
import fr.uge.poo.amanet.inventory.SalesTracker;
import fr.uge.poo.amanet.items.Item;
import fr.uge.poo.amanet.items.Item.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static fr.uge.poo.amanet.client.Country.*;

public class Application {

    static List<Item> gamesAfter(int year, List<Item> list){
        return list.stream()
                .filter(elem -> elem.type() == Item.TYPE_ITEM.VIDEOGAMES && elem.getYear() > year)
                .toList();
    }

    static int movies(List<Item> list){
        return (int) list.stream()
                .filter(elem -> elem.type() == Item.TYPE_ITEM.BLURAY && elem.type() == Item.TYPE_ITEM.DVD)
                .count();
    }

    public static void main(String[] args) {
        //EXERCICE 1
        var test1 = Step.newbuilder().nom("Kingué")
                .prenom("Alexandre")
                .age(15)
                .county(FRANCE)
                .infoEMAIL("alexandre@gmail.com")
                .infoTWITTER("MrKDL")
                .build();

        test1.message("Test 1");
        //Notification par défaut: Aucun affichage

        test1.emailNotif();
        test1.message("Test 2");
        //Notification par email: 'Sending email to alexandre@gmail.com with content Test 2'

        test1.smsNotif();
        test1.message("Test 3");
        //Notification par sms: Aucun affichage (aucun numéro de téléphone de donné)

        test1.twitterNotif();
        test1.message("Test 4");
        //Notification par Twitter: 'Sending tweet to MrKDL with content Test 4'

        //EXERCICE 2
        var test2 = Step.newbuilder().nom("Steven")
                .prenom("Ly-Weng")
                .age(26)
                .county(ANGLETERRE)
                .infoEMAIL("steven@gmail.com")
                .infoTWITTER("KingRail")
                .build();

        Item doomGame = new Item.VideoGames("Doom", 2020, Item.PLATEFORM.PC, client -> client.getAge() > 18);
        Item avatarDVD = new Item.DVD("Avatar", 2009, Set.of(ANGLETERRE, FRANCE), 2 , client -> !client.getCountry().equals(FRANCE));

        System.out.println("Doom allowed for adult client: " + doomGame.isAllowedForClient(test2)); // true
        System.out.println("Avatar allowed for French client: " + avatarDVD.isAllowedForClient(test1)); // false

        //EXERCICE 3
        // Create services
        NotificationService notificationService = new NotificationService();
        SalesTracker salesTracker = new SalesTracker();

        // Create inventory
        Inventory inventory = new Inventory();

        // Create items
        Item dvd = new DVD("Avatar", 2009, Set.of(ANGLETERRE, FRANCE), 1, client -> !client.getCountry().equals(FRANCE));
        Item bluRay = new BluRay("Inception", 2010, Set.of(ANGLETERRE, ESPAGNE), true, client -> client.getAge() < 20);
        Item game = new VideoGames("Doom", 2020, PLATEFORM.PC, client -> (true));

        // Add items to inventory
        inventory.add(dvd, 5);
        inventory.add(bluRay, 2);
        inventory.add(game, 1);


        // Successful purchase of a DVD
        System.out.println("--- Testing DVD purchase ---");
        boolean success1 = inventory.retrieve(dvd, test2);
        System.out.println("Purchase successful: " + success1);

        // Successful purchase of a Blu-Ray
        System.out.println("--- Testing Blu-Ray purchase ---");
        boolean success2 = inventory.retrieve(bluRay, test2);
        System.out.println("Purchase successful: " + success2);

        // Attempt to purchase an out-of-stock game
        System.out.println("--- Testing out-of-stock game purchase ---");
        inventory.retrieve(game, test2); // First purchase, reduces stock to 0
        boolean success3 = inventory.retrieve(game, test2); // Second attempt fails
        System.out.println("Purchase successful: " + success3);

        // Attempt to purchase a restricted item
        System.out.println("--- Testing restricted item purchase ---");
        boolean success4 = inventory.retrieve(game, test1);
        System.out.println("Purchase successful: " + success4);

        // Check total games sold
        System.out.println("--- Total games sold ---");
        System.out.println("Total games sold: " + salesTracker.getTotalGamesSold());

        // Check stock after purchases
        System.out.println("--- Inventory after purchases ---");
        System.out.println(inventory);

    }
}
