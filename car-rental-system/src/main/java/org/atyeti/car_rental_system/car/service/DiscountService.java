package org.atyeti.car_rental_system.car.service;



import org.atyeti.car_rental_system.car.dtos.DiscountDtos;

import java.util.List;

public interface DiscountService {

    DiscountDtos.DiscountResponse createDiscount(DiscountDtos.DiscountRequest request);

    List<DiscountDtos.DiscountResponse> getAllDiscounts();

    DiscountDtos.DiscountResponse applyDiscount(DiscountDtos.ApplyDiscountRequest request);
}
