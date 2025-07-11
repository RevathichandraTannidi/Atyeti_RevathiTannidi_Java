package org.atyeti.orderfulfillmentSystem.service;

import org.atyeti.orderfulfillmentSystem.model.Order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderService {
    private final List<Order> fulfilledOrders = Collections.synchronizedList(new ArrayList<>());
    private final List<Order> rejectedOrders = Collections.synchronizedList(new ArrayList<>());

    public void logFulfilledOrder(Order order) {
        fulfilledOrders.add(order);
    }

    public void logRejectedOrder(Order order) {
        rejectedOrders.add(order);
    }

}
