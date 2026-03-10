package org.atyeti.ordermatching.concurrency;

import lombok.AllArgsConstructor;
import org.atyeti.ordermatching.matching.MatchingEngine;
import org.atyeti.ordermatching.model.Orders;
import org.atyeti.ordermatching.orderbook.OrderBook;
import org.atyeti.ordermatching.orderbook.OrderBookManager;

import java.util.List;
import java.util.Set;
import java.util.concurrent.*;
@AllArgsConstructor
public class OrderProcessor {

    private final OrderBookManager bookManager;
    private final MatchingEngine engine;
    private final ExecutorService executor;
    private final Set<String> processedOrderIds = ConcurrentHashMap.newKeySet();


    public void submitOrders(List<Orders> orders) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(orders.size());

        for (Orders order : orders) {
            executor.submit(() -> {
                try {
                    if (!processedOrderIds.add(order.getOrderId())) {
                        System.out.println("Duplicate order skipped: " + order.getOrderId());
                        return;
                    }
                    OrderBook book = bookManager.getOrderBook(order.getTradeType());
                    engine.processOrder(book, order);
                } finally {
                    latch.countDown();
                }
            });
        }

        latch.await();
    }

    public void shutdown() {
        executor.shutdown();
    }
}

