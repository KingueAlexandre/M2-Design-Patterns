package fr.uge.poo.amanet.inventory;

import com.evilcorp.connect.Connect;
import fr.uge.poo.amanet.client.Client;
import fr.uge.poo.amanet.items.Item;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Inventory {
    private final Map<Item,Integer> mapStockage;
    private final SalesTracker tracker = new SalesTracker();
    private final NotificationService notificationService = new NotificationService();

    public Inventory() {
        this.mapStockage = new HashMap<Item,Integer>();
    }


    public void add(Item item,int quantity){
        Objects.requireNonNull(item);
        if(quantity < 0){
            throw new IllegalArgumentException();
        }
        if(mapStockage.containsKey(item)){
            mapStockage.put(item,mapStockage.get(item)+quantity);
        }else{
            mapStockage.put(item,quantity);
        }
    }

    public boolean retrieve(Item item, Client client){
        Objects.requireNonNull(item);
        Objects.requireNonNull(client);
        this.notificationService.notifyClient(client,item);
        if(mapStockage.containsKey(item) && item.isAllowedForClient(client)){
            int quantity = mapStockage.get(item);
            if(quantity > 0){
                if(quantity == 1){
                    this.notificationService.notifySupply(item);
                }
                tracker.recordSale(item);
                mapStockage.put(item,mapStockage.get(item)-1);
                return true;
            }else {
                this.notificationService.notifyMarketing(item,client);
            }
        }
        return false;
    }



}

/**
 * SOLID Principles Comment:
 *
 * Adding these behaviors directly into the retrieve method violates the Single Responsibility Principle (SRP).
 * The retrieve method is now responsible for inventory management, client notifications, and email communications.
 *
 * A better design would delegate these responsibilities to separate classes or services (e.g., a NotificationService
 * and a StockManagementService). This would keep the retrieve method focused solely on inventory logic, improving
 * maintainability and adhering to SRP.
 */
