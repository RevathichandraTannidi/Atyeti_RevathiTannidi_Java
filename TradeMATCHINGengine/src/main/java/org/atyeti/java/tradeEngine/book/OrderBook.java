package org.atyeti.java.tradeEngine.book;

import org.atyeti.java.tradeEngine.model.Orders;

import java.util.Queue;

public interface OrderBook {
// Returns all buy orders stored in the order book
    Queue<Orders> getBuyOrders();
    // Returns all sell orders stored in the order book
    Queue<Orders> getSellOrders();
    void addOrder(Orders order);// add new order buy or sell
}