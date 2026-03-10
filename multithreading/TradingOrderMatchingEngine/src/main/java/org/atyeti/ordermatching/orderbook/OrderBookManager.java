package org.atyeti.ordermatching.orderbook;

import org.atyeti.ordermatching.model.Orders;
import org.atyeti.ordermatching.model.TradeType;

import java.util.EnumMap;
import java.util.Map;
import java.util.List;

public class OrderBookManager {

    private static final Map<TradeType, OrderBook> books = new EnumMap<>(TradeType.class);

    static {
        for (TradeType t : TradeType.values()) {
            books.put(t, new PriceTimeOrderBook());
        }
    }

    public static OrderBook getOrderBook(TradeType tradeType) {
        return books.get(tradeType);
    }
}
