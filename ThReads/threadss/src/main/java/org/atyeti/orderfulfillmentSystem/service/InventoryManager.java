package org.atyeti.orderfulfillmentSystem.service;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InventoryManager {
    private final Map<String, Integer> inventory = new ConcurrentHashMap<>();

    public InventoryManager() {
        inventory.put("Laptop", 10);
        inventory.put("Phone", 15);
        inventory.put("Monitor", 8);
    }

    public synchronized boolean fulfillOrder(String item, int quantity) {
        int available = inventory.getOrDefault(item, 0);
        if (available >= quantity) {
            inventory.put(item, available - quantity);
            return true;
        }
        return false;
    }

    public Map<String, Integer> getInventory() {
        return inventory;
    }
}
