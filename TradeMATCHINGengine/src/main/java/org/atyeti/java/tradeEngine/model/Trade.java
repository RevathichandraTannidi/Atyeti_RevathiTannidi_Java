package org.atyeti.java.tradeEngine.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Trade {
    private String buyOrderId;
    private String sellOrderId;
    private TradeType tradeType;
    private double price;
    private long quantity;
    private long timestamp;
}
