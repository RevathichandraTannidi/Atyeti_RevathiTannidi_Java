package com.atyeti.collections.mapcollection;
import java.util.*;
public class Inventory {
        private final Map<String, Map<String, Integer>> inventory = new HashMap<>();

    public void addStock(String warehouseId, String productId, int quantity) {
        inventory.computeIfAbsent(warehouseId, k -> new HashMap<>())
                .compute(productId, (k, v) -> (v == null) ? quantity : v + quantity);
    }

    public boolean removeStock(String warehouseId, String productId, int quantity) {
        Map<String, Integer> warehouse = inventory.get(warehouseId);
        if (warehouse == null)
            return false;
        Integer csk = warehouse.get(productId);
        if (csk == null || csk < quantity)
            return false;

        warehouse.put(productId, csk - quantity);
        return true;
    }


    public int getTotalStock(String productId) {
        return inventory.values().stream().mapToInt(map -> map.getOrDefault(productId, 0)).sum();
    }


    public static void main(String[] args) {
        Inventory manage = new Inventory();

        manage.addStock("WH1", "P1", 50);
         manage.addStock("WH1", "P2", 30);
         manage.addStock("WH2", "P1", 20);
        manage.addStock("WH2", "P3", 40);

        System.out.println("Remove  " + manage.removeStock("WH1", "P1", 10));
         System.out.println("Remove " + manage.removeStock("WH2", "P1", 25));

        System.out.println("Total P1: " + manage.getTotalStock("P1"));
          System.out.println("Total P2: " + manage.getTotalStock("P2"));
        System.out.println("Total P3: " + manage.getTotalStock("P3"));
        System.out.println("Total P9: " + manage.getTotalStock("P9"));
    }
    }

//Scenario:
//An online store needs to manage its inventory across multiple warehouses. Each warehouse holds different quantities of products.
//Requirements:
//Use Map<String, Map<String, Integer>>:
//Outer key = warehouse ID
//Inner map = product ID → quantity
//Implement:
//void addStock(String warehouseId, String productId, int quantity)
//void removeStock(String warehouseId, String productId, int quantity)
//int getTotalStock(String productId) —
