package org.atyeti.orderfulfillmentSystem;

import org.atyeti.orderfulfillmentSystem.service.InventoryManager;
import org.atyeti.orderfulfillmentSystem.service.OrderService;
import org.atyeti.orderfulfillmentSystem.threads.OrderWorker;

public class OrderfullFill{

        public static void main(String[] args) throws InterruptedException {
            InventoryManager inventory = new InventoryManager();
            OrderService orderService = new OrderService();

            Thread t1 = new Thread(new OrderWorker("C101", inventory, orderService));
            Thread t2 = new Thread(new OrderWorker("C102", inventory, orderService));
            Thread t3 = new Thread(new OrderWorker("C103", inventory, orderService));

            t1.start(); t2.start(); t3.start();
            t1.join(); t2.join(); t3.join();

            orderService.printSummary();

            System.out.println("\n Final Inventory: " + inventory.getInventory());
        }
    }


