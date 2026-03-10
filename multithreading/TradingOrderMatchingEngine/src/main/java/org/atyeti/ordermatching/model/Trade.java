package org.atyeti.ordermatching.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.atyeti.ordermatching.model.TradeType;

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
