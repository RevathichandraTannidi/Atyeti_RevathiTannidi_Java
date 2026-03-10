package org.atyeti.ordermatching.validation;


import org.atyeti.ordermatching.exception.InsufficientQuantityException;
import org.atyeti.ordermatching.exception.InvalidCountryException;
import org.atyeti.ordermatching.exception.InvalidOrderException;
import org.atyeti.ordermatching.exception.ValidationException;
import org.atyeti.ordermatching.model.Orders;

public class FieldValidator implements OrderValidator {

    @Override
    public void validate(Orders order) throws Exception {
        if (order == null) throw new ValidationException("Order is null");
        if (order.getOrderId() == null || order.getOrderId().trim().isEmpty())
            throw new ValidationException("OrderId is invalid");
        if (order.getTraderId() == null || order.getTraderId().trim().isEmpty())
            throw new ValidationException("TraderId is invalid");
        if (order.getTradeType() == null)
            throw new ValidationException("TradeType is null");
        if (order.getOrderType() == null)
            throw new InvalidOrderException("OrderType is null");
        if (order.getPrice() <= 0)
            throw new ValidationException("Price must be positive");
        if (order.getQuantity() <= 0)
            throw new InsufficientQuantityException("Quantity must be positive");
        if (order.getCountryCode() == null || order.getCountryCode().trim().isEmpty())
            throw new InvalidCountryException("Country code is null or empty");
    }

}
