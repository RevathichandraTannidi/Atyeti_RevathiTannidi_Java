package org.atyeti.java.tradeEngine.matchingEngine;


import org.atyeti.java.tradeEngine.book.OrderBook;
import org.atyeti.java.tradeEngine.model.OrderStatus;
import org.atyeti.java.tradeEngine.model.Orders;

//It controls how each order is processed and sets final order status.
public class MatchingEngine {

    private final MatchingStrategy strategy;

    public MatchingEngine(MatchingStrategy strategy) {
        this.strategy = strategy;
    }

    public void processOrder(OrderBook orderBook, Orders order) {
        long originalQty = order.getRemainingQuantity();
        strategy.match(orderBook, order);
        long matchedQty = originalQty - order.getRemainingQuantity(); // how much got matched

        if (matchedQty == originalQty && originalQty > 0) {
            order.setStatus(OrderStatus.FILLED);
        }
        else if (matchedQty > 0){
            order.setStatus(OrderStatus.PARTIALLY_FILLED);
        }
        else if (originalQty > 0) {
            order.setStatus(OrderStatus.PENDING);
        }
        else
        {
            order.setStatus(OrderStatus.REJECTED);
        }
    }
}

