package org.atyeti.ordermatching.matching;

import org.atyeti.ordermatching.model.Orders;
import org.atyeti.ordermatching.orderbook.OrderBook;

public interface MatchingStrategy {
    void match(OrderBook book, Orders incoming);
}
