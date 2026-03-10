package org.atyeti.ordermatching.validation;

import org.atyeti.ordermatching.exception.InvalidCountryException;
import org.atyeti.ordermatching.model.Orders;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class CountryValidator implements OrderValidator {

    private static final Set<String> ALLOWED_COUNTRIES = new HashSet<>(Arrays.asList(
            "US","UK","IN","SG","JP","DE","FR"
    ));

    @Override
    public void validate(Orders order) throws Exception {
        if (!ALLOWED_COUNTRIES.contains(order.getCountryCode().toUpperCase())) {
            throw new InvalidCountryException("this country not allowed: " + order.getCountryCode());
        }
    }


}

