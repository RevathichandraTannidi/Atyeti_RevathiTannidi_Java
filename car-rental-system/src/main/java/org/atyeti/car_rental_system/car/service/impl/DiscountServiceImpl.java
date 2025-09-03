package org.atyeti.car_rental_system.car.service.impl;


import lombok.RequiredArgsConstructor;
import org.atyeti.car_rental_system.car.dao.DiscountRepository;
import org.atyeti.car_rental_system.car.dtos.DiscountDtos;
import org.atyeti.car_rental_system.car.entity.Discount;
import org.atyeti.car_rental_system.car.service.DiscountService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DiscountServiceImpl implements DiscountService {

    private final DiscountRepository discountRepository;




    @Override
    public DiscountDtos.DiscountResponse createDiscount(DiscountDtos.DiscountRequest request) {
        Discount discount = Discount.builder()
                .code(request.getCode())
                .value(request.getValue())
                .expiryDate(LocalDate.now().plusDays(request.getExpiryDays() > 0 ? request.getExpiryDays() : 30))
                .build();

        discountRepository.save(discount);

        return DiscountDtos.DiscountResponse.builder()
                .code(discount.getCode())
                .originalPrice(0)
                .discountedPrice(discount.getValue())
                .message("Discount created successfully")
                .build();
    }

    @Override
    public List<DiscountDtos.DiscountResponse> getAllDiscounts() {
        LocalDate today = LocalDate.now();
        List<Discount> discounts = discountRepository.findActiveDiscounts(today);

        return discounts.stream()
                .map(discount -> mapToResponse(discount, 0)) // originalPrice unknown, set 0 or adjust
                .collect(Collectors.toList());
    }

    @Override
    public DiscountDtos.DiscountResponse applyDiscount(DiscountDtos.ApplyDiscountRequest request) {
        Discount discount = discountRepository.findByCode(request.getCode())
                .orElseThrow(() -> new RuntimeException("Invalid discount code"));

        if (discount.getExpiryDate().isBefore(LocalDate.now())) {
            throw new RuntimeException("Discount code expired");
        }

        double discountedPrice = request.getPrice() - discount.getValue();
        if (discountedPrice < 0) discountedPrice = 0;

        return DiscountDtos.DiscountResponse.builder()
                .code(discount.getCode())
                .originalPrice(request.getPrice())
                .discountedPrice(discountedPrice)
                .message("Discount applied successfully")
                .build();
    }

    private DiscountDtos.DiscountResponse mapToResponse(Discount discount, double originalPrice) {
        return DiscountDtos.DiscountResponse.builder()
                .code(discount.getCode())
                .originalPrice(originalPrice)
                .discountedPrice(discount.getValue())
                .message("Active discount")
                .build();
    }
}
