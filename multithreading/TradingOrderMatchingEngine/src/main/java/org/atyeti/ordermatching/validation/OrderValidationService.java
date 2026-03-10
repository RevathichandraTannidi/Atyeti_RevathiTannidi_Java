package org.atyeti.ordermatching.validation;

import org.atyeti.ordermatching.model.Orders;
import java.util.ArrayList;
import java.util.List;

public class OrderValidationService implements OrderValidator {

    private final List<OrderValidator> validators = new ArrayList<>();

    public OrderValidationService(List<OrderValidator> validators) {
        this.validators.addAll(validators);
    }

    public void addValidator(OrderValidator v) {
        validators.add(v);
    }

    @Override
    public void validate(Orders order) throws Exception {
        for (OrderValidator v : validators) {
            v.validate(order);
        }
    }
}
