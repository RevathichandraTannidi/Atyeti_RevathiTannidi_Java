package org.atyeti.ordermatching.matching;

import org.atyeti.ordermatching.model.OrderType;
import org.atyeti.ordermatching.model.Orders;
import org.atyeti.ordermatching.orderbook.OrderBook;
import org.atyeti.ordermatching.orderbook.PriceTimeOrderBook;

public class PriceTimePriorityStrategy implements MatchingStrategy {

    @Override
    public void match(OrderBook orderBook, Orders incoming) {
        if (incoming.getOrderType() == OrderType.BUY) {
            matchBuy((PriceTimeOrderBook) orderBook, incoming);
        } else {
            matchSell((PriceTimeOrderBook) orderBook, incoming);
        }
    }

    private void matchBuy(PriceTimeOrderBook book, Orders buy) {
        // match while there is buy remaining and there exists a sell that satisfies price
        while (buy.getRemainingQuantity() > 0) {
            Orders bestSell;
            synchronized (book) {
                bestSell = book.peekBestSell();
            }
            if (bestSell == null) break;
            // Price check
            if (buy.getPrice() < bestSell.getPrice()) break;

            long qty;
            // compute trade qty
            qty = Math.min(buy.getRemainingQuantity(), bestSell.getRemainingQuantity());
            if (qty <= 0) break;

            // execute trade: reduce both sides
            buy.reduceQuantity(qty);
            bestSell.reduceQuantity(qty);

            // Execution price: use resting order price (bestSell.getPrice())
            System.out.println("TRADE: BUY " + buy.getTraderId()
                    + " <--> SELL " + bestSell.getTraderId()
                    + " QTY=" + qty + " PRICE=" + bestSell.getPrice());

            // remove bestSell if filled
            if (bestSell.isFilled()) {
                synchronized (book) {
                    // poll the filled sell
                    Orders polled = book.pollBestSell();
                    // sanity check: polled should be same reference or same id
                }
            }
        }

        // After matching, if buy still has remaining -> add to book once
        if (!buy.isFilled()) {
            synchronized (book) {
                book.addOrder(buy);
            }
        }
    }

    private void matchSell(PriceTimeOrderBook book, Orders sell) {
        while (sell.getRemainingQuantity() > 0) {
            Orders bestBuy;
            synchronized (book) {
                bestBuy = book.peekBestBuy();
            }
            if (bestBuy == null) break;
            // Price check: bestBuy.price >= sell.price
            if (bestBuy.getPrice() < sell.getPrice()) break;

            long qty = Math.min(bestBuy.getRemainingQuantity(), sell.getRemainingQuantity());
            if (qty <= 0) break;

            bestBuy.reduceQuantity(qty);
            sell.reduceQuantity(qty);

            System.out.println("TRADE: BUY " + bestBuy.getTraderId()
                    + " <--> SELL " + sell.getTraderId()
                    + " QTY=" + qty + " PRICE=" + sell.getPrice());

            if (bestBuy.isFilled()) {
                synchronized (book) {
                    book.pollBestBuy();
                }
            }
        }

        if (!sell.isFilled()) {
            synchronized (book) {
                book.addOrder(sell);
            }
        }
    }
}
