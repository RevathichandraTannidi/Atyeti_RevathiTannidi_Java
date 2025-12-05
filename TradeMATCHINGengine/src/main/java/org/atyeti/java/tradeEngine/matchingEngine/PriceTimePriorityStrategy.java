package org.atyeti.java.tradeEngine.matchingEngine;

import org.atyeti.java.tradeEngine.book.OrderBook;
import org.atyeti.java.tradeEngine.book.PriceTimeOrderBook;
import org.atyeti.java.tradeEngine.model.OrderType;
import org.atyeti.java.tradeEngine.model.Orders;

public class PriceTimePriorityStrategy implements MatchingStrategy {

    @Override
    public void match(OrderBook orderBook, Orders incoming) {
        PriceTimeOrderBook book = (PriceTimeOrderBook) orderBook;
        if (incoming.getOrderType() == OrderType.BUY) {  // Decide whether to match as BUY or SELL
            matchBuy(book, incoming);
        }
        else
        {
            matchSell(book, incoming);
        }
    }

    private void matchBuy(PriceTimeOrderBook book, Orders buy) {

        while (buy.getRemainingQuantity() > 0) {
            Orders bestSell;
            synchronized (book) {
                bestSell = book.peekBestSell();
            }

            if (bestSell == null || buy.getPrice() < bestSell.getPrice())
            {
                break; // Stop if book is empty OR prices do not match
            }
            long qty = Math.min(buy.getRemainingQuantity(), bestSell.getRemainingQuantity());

            // Reduce quantities from both sides
            buy.reduceQuantity(qty);
            bestSell.reduceQuantity(qty);
            System.out.println("TRADE: BUY " + buy.getTraderId()
                    + " <--> SELL " + bestSell.getTraderId()
                    + " QTY=" + qty + " PRICE=" + bestSell.getPrice());
            if (bestSell.isFilled())
            {
                synchronized (book)
                {
                    book.pollBestSell(); // if sell is filled, remove it from the book .
                }
            }
        }

        if (!buy.isFilled()) {
            synchronized (book)
            {
                book.addOrder(buy); // if buy still have quantity left, add into the book
            }
        }
    }

    private void matchSell(PriceTimeOrderBook book, Orders sell) {
        while (sell.getRemainingQuantity() > 0) {
            Orders bestBuy;
            synchronized (book) {
                bestBuy = book.peekBestBuy();
            }
            if (bestBuy == null || bestBuy.getPrice() < sell.getPrice())
            {
                break;
            }
            // Determine how much quantity can trade
            long qty = Math.min(bestBuy.getRemainingQuantity(), sell.getRemainingQuantity());
            sell.reduceQuantity(qty);
            bestBuy.reduceQuantity(qty);
            System.out.println("TRADE: BUY " + bestBuy.getTraderId()
                    + " <--> SELL " + sell.getTraderId()
                    + " QTY=" + qty + " PRICE=" + sell.getPrice());

            // If BUY is fully matched, remove it
            if (bestBuy.isFilled())
            { synchronized (book)
            {
                book.pollBestBuy();
            }
            }
        }

        // Remaining SELL quantity goes into the book
        if (!sell.isFilled()) {
            synchronized (book)
            {
                book.addOrder(sell);
            }
        }
    }
}
