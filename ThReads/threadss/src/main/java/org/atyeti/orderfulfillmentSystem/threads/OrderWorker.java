package org.atyeti.orderfulfillmentSystem.threads;

import org.atyeti.orderfulfillmentSystem.model.Order;
import org.atyeti.orderfulfillmentSystem.service.InventoryManager;
import org.atyeti.orderfulfillmentSystem.service.OrderService;

import java.util.UUID;

public class OrderWorker implements Runnable {
    private final String customerId;
    private final InventoryManager inventory;
    private final OrderService orderService;

    public OrderWorker(String customerId, InventoryManager inventory, OrderService orderService) {
        this.customerId = customerId;
        this.inventory = inventory;
        this.orderService = orderService;
    }

    @Override
    public void run() {
        String[] items = {"Laptop", "Phone", "Monitor"};
        for (int i = 0; i < 3; i++) {
            String item = items[(int) (Math.random() * items.length)];
            int qty = 1 + (int) (Math.random() * 3);
            Order order = new Order(UUID.randomUUID().toString(), customerId, item, qty);

            if (inventory.fulfillOrder(item, qty)) {
                orderService.FulfilledOrder(order);
            } else {
                orderService.RejectedOrder(order);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
