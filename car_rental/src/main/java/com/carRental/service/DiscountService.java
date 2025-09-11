package com.carRental.service;

import com.carRental.entity.Discount;
import com.carRental.entity.enumss.DiscountType;
import com.carRental.exceptionhandling.BadRequestException;
import com.carRental.exceptionhandling.ResourceNotFoundException;
import com.carRental.repository.DiscountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DiscountService {
    private final DiscountRepository discountRepository;

    public Discount createDiscount(Discount discount) {
        if (discount == null) {
            throw new BadRequestException("Discount cannot be null");
        }
        if (discount.getValue() <= 0) {
            throw new BadRequestException("Discount value must be greater than zero");
        }
        if (discount.getType() == DiscountType.PERCENTAGE && discount.getValue() > 100) {
            throw new BadRequestException("Percentage discount cannot exceed 100%");
        }
        if (discount.getExpiryDate() == null || discount.getExpiryDate().isBefore(LocalDate.now())) {
            throw new BadRequestException("Discount expiry date must be valid and in the future");
        }
        return discountRepository.save(discount);
    }

    public List<Discount> getActiveDiscounts() {
        List<Discount> discounts = discountRepository.findActiveDiscounts(LocalDate.now());
        if (discounts.isEmpty()) {
            throw new ResourceNotFoundException("No active discounts found");
        }
        return discounts;
    }

    public double applyDiscount(String code, double originalAmount) {
        if (originalAmount <= 0) {
            throw new BadRequestException("Original amount must be greater than zero");
        }

        Discount discount = discountRepository.findByCode(code)
                .orElseThrow(() -> new ResourceNotFoundException("Invalid discount code: " + code));

        if (discount.getExpiryDate().isBefore(LocalDate.now())) {
            throw new BadRequestException("Discount code has expired: " + code);
        }

        if (discount.getType() == DiscountType.PERCENTAGE) {
            return originalAmount - (originalAmount * discount.getValue() / 100);
        } else if (discount.getType() == DiscountType.FLAT) {
            double discounted = originalAmount - discount.getValue();
            return discounted < 0 ? 0 : discounted; // avoid negative totals
        } else {
            throw new BadRequestException("Unsupported discount type: " + discount.getType());
        }
    }
}
