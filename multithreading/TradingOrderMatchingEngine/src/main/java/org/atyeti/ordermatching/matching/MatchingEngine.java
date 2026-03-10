package org.atyeti.ordermatching.matching;

import org.atyeti.ordermatching.model.OrderStatus;
import org.atyeti.ordermatching.model.Orders;
import org.atyeti.ordermatching.orderbook.OrderBook;

public class MatchingEngine {

    private final MatchingStrategy strategy;

    public MatchingEngine(MatchingStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Process a single order: delegate matching to strategy,
     * then set the final status (FILLED / PARTIALLY_FILLED / PENDING).
     * Strategy is responsible for adding leftover to the order book exactly once.
     */
    public void processOrder(OrderBook orderBook, Orders order) {

        long originalRemaining = order.getRemainingQuantity();

        // strategy does the matching and will add leftover if any
        strategy.match(orderBook, order);

        long remaining = order.getRemainingQuantity();
        long matched = originalRemaining - remaining;

        if (remaining == 0 && originalRemaining > 0) {
            order.setStatus(OrderStatus.FILLED);
            System.out.println("ORDER " + order.getOrderId() + " FULLY FILLED");
        } else if (matched > 0 && remaining > 0) {
            order.setStatus(OrderStatus.PARTIALLY_FILLED);
            System.out.println("ORDER " + order.getOrderId() +
                    " PARTIALLY FILLED. REMAINING: " + remaining);
        } else {
            order.setStatus(OrderStatus.PENDING);
            System.out.println("ORDER " + order.getOrderId() +
                    " PENDING — added to order book");
        }
    }
}
