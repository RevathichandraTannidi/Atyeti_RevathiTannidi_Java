package org.atyeti.orderfulfillmentSystem.threads;

import org.atyeti.orderfulfillmentSystem.model.Order;
import org.atyeti.orderfulfillmentSystem.service.InventoryManager;
import org.atyeti.orderfulfillmentSystem.service.OrderCsv;
import org.atyeti.orderfulfillmentSystem.service.OrderService;

import java.util.List;


public class OrderWorker implements Runnable {
    private final List<Order> ordersToProcess;
    private final InventoryManager inventory;
    private final OrderService orderService;
    private final OrderCsv logger;

    public OrderWorker(List<Order> orders, InventoryManager inventory, OrderService orderService, OrderCsv logger) {
        this.ordersToProcess = orders;
        this.inventory = inventory;
        this.orderService = orderService;
        this.logger = logger;
    }


    @Override
    public void run() {
        for (Order order : ordersToProcess) {
            if ("REJECT".equalsIgnoreCase(order.getStatusHint())) {
                orderService.logRejectedOrder(order);
                logger.logRejectedOrder(order);
                continue;
            }

            boolean fulfilled = inventory.fulfillOrder(order.getItemName(), order.getQuantity());
            if (fulfilled) {
                orderService.logFulfilledOrder(order);
                logger.logFulfilledOrder(order);
            } else {
                orderService.logRejectedOrder(order);
                logger.logRejectedOrder(order);
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

}

