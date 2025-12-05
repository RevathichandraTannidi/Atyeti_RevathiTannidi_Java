package org.atyeti.java.tradeEngine.validation;

import org.atyeti.java.tradeEngine.model.Orders;
//  main interface for all the validators
public interface OrderValidator {
    void validate(Orders order) throws Exception;
}