package org.atyeti.orderfulfillmentSystem.service;

import org.atyeti.orderfulfillmentSystem.model.Order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderService {
    private final List<Order> fulfilledOrders = Collections.synchronizedList(new ArrayList<>());
    private final List<Order> rejectedOrders = Collections.synchronizedList(new ArrayList<>());

    public void FulfilledOrder(Order order) {
        fulfilledOrders.add(order);
    }

    public void RejectedOrder(Order order) {
        rejectedOrders.add(order);
    }

    public void printSummary() {
        System.out.println(" Fulfilled Orders: " + fulfilledOrders.size());
        fulfilledOrders.forEach(System.out::println);
        System.out.println("Rejected Orders: " + rejectedOrders.size());
        rejectedOrders.forEach(System.out::println);
    }
}
