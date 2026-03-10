package org.atyeti.ordermatching.validation;


import org.atyeti.ordermatching.model.Orders;

public interface OrderValidator {
    void validate(Orders order) throws Exception;
}
//string getvalidatorname();