package fr.uge.poo.amanet.inventory;

import fr.uge.poo.amanet.items.Item;

public class SalesTracker {
    private int totalGamesSold = 0;

    public void recordSale(Item item) {
        if (item.type() == Item.TYPE_ITEM.VIDEOGAMES) {
            totalGamesSold++;
        }
    }

    public int getTotalGamesSold() {
        return totalGamesSold;
    }
}
