package org.atyeti.ordermatching.orderbook;

import org.atyeti.ordermatching.model.Orders;

import java.util.Queue;

public interface OrderBook {

    // Just declare the methods, no fields
    Queue<Orders> getBuyOrders();
    Queue<Orders> getSellOrders();

    void addOrder(Orders order);
}
