package org.atyeti.java.tradeEngine.book;

import org.atyeti.java.tradeEngine.model.TradeType;

import java.util.EnumMap;
import java.util.Map;

public class OrderBookManager {

    // stores it separate order book for trade type : FOREX,EQUITY ,CRYPTO
    private static final Map<TradeType, OrderBook> books = new EnumMap<>(TradeType.class);

    static {
        for (TradeType t : TradeType.values()) {
            books.put(t, new PriceTimeOrderBook());
        }
    }
// Returns the OrderBook for the given TradeType
    public static OrderBook getOrderBook(TradeType tradeType) {
        return books.get(tradeType);
    }
}
