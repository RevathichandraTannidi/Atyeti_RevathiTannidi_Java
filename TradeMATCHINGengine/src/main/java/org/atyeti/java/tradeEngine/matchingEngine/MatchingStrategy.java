package org.atyeti.java.tradeEngine.matchingEngine;

import org.atyeti.java.tradeEngine.book.OrderBook;
import org.atyeti.java.tradeEngine.model.Orders;

public interface MatchingStrategy {
    void match(OrderBook book, Orders incoming);// defines matching orders in the book

}
