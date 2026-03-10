package org.atyeti.ordermatching.orderbook;

import org.atyeti.ordermatching.model.OrderType;
import org.atyeti.ordermatching.model.Orders;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriceTimeOrderBook implements OrderBook {

    private final PriorityQueue<Orders> buyOrders = new PriorityQueue<>(
            Comparator.comparingDouble(Orders::getPrice).reversed()
                    .thenComparing(Orders::getTimestamp)
    );

    private final PriorityQueue<Orders> sellOrders = new PriorityQueue<>(
            Comparator.comparingDouble(Orders::getPrice)
                    .thenComparing(Orders::getTimestamp)
    );

    @Override
    public synchronized void addOrder(Orders order) {
        if (order.getOrderType() == OrderType.BUY) buyOrders.offer(order);
        else sellOrders.offer(order);
    }

    @Override
    public synchronized Queue<Orders> getBuyOrders() {
        return buyOrders;
    }

    @Override
    public synchronized Queue<Orders> getSellOrders() {
        return sellOrders;
    }

    public synchronized Orders peekBestBuy() {
        return buyOrders.peek();
    }

    public synchronized Orders peekBestSell() {
        return sellOrders.peek();
    }

    public synchronized Orders pollBestBuy() {
        return buyOrders.poll();
    }

    public synchronized Orders pollBestSell() {
        return sellOrders.poll();
    }

    public synchronized int getBuyOrderCount() {
        return buyOrders.size();
    }

    public synchronized int getSellOrderCount() {
        return sellOrders.size();
    }
}
