package org.atyeti.ordermatching.validation;


import org.atyeti.ordermatching.exception.AmountLimitExceededException;
import org.atyeti.ordermatching.exception.ValidationException;
import org.atyeti.ordermatching.model.*;

public class MaxAmountValidator implements OrderValidator {

    @Override
    public void validate(Orders order) throws Exception {
        double value = order.getPrice() * order.getQuantity();
        TradeType type = order.getTradeType();
        switch (type) {
            case EQUITY:
                if (value > 100_000) throw new AmountLimitExceededException("EQUITY order exceeds 100000");
                break;
            case FOREX:
                if (value > 500_000) throw new AmountLimitExceededException("FOREX order exceeds 500000");
                break;
            case CRYPTO:
                if (value > 50_000) throw new AmountLimitExceededException("CRYPTO order exceeds 50000");
                break;
            default:
                throw new ValidationException("not the TradeType: " + type);
        }
    }
}

