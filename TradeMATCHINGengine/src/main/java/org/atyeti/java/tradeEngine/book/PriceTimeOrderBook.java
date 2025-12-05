package org.atyeti.java.tradeEngine.book;

import org.atyeti.java.tradeEngine.model.OrderType;
import org.atyeti.java.tradeEngine.model.Orders;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriceTimeOrderBook implements OrderBook {

    // Priority queue for BUY orders: highest price first, then earliest timestamp
    private final PriorityQueue<Orders> buyOrders = new PriorityQueue<>(
            Comparator.comparingDouble(Orders::getPrice).reversed()
                    .thenComparing(Orders::getTimestamp)
    );

    // Priority queue for SELL orders: lowest price first
    private final PriorityQueue<Orders> sellOrders = new PriorityQueue<>(
            Comparator.comparingDouble(Orders::getPrice)
                    .thenComparing(Orders::getTimestamp)
    );

    @Override
    public synchronized void addOrder(Orders order) {
        //add order to buy or sell queue based on type
        if (order.getOrderType() == OrderType.BUY)
        {
            buyOrders.offer(order);
        }
        else
        {
            sellOrders.offer(order);
        }
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
        return sellOrders.peek();  // look at highest priority  sell
    }
    public synchronized Orders pollBestBuy() {
        return buyOrders.poll();  // Remove and return highest priority BUY order
    }
    public synchronized Orders pollBestSell() {
        return sellOrders.poll(); // same as like before remove and return high priority sell order
    }
}