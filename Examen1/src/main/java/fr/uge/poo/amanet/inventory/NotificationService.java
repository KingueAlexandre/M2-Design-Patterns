package fr.uge.poo.amanet.inventory;

import com.evilcorp.connect.Connect;
import fr.uge.poo.amanet.client.Client;
import fr.uge.poo.amanet.items.Item;

// NotificationService to handle client and supply notifications
public class NotificationService {

    public void notifyClient(Client client, Item item) {
        String message = "You have successfully purchased: \n" +
                item.getLongDescription() + "\nPrice: " + item.getPrice() + " euros.";
        client.message(message);
    }

    public void notifySupply(Item item) {
        String subject = "Restock needed for: " + item.getShortDescription();
        String message = "The item is out of stock and needs to be reordered.";
        Connect.sendMail("supply@amanet.com", subject, message);
    }

    public void notifyMarketing(Item item, Client client) {
        String subject = "Attempt to purchase out-of-stock item";
        String message = "Client " + client.getPrenom() + " " + client.getNom() +
                " tried to purchase the out-of-stock item: \n" + item.getShortDescription();
        Connect.sendMail("marketing@amanet.com", subject, message);
    }
}
