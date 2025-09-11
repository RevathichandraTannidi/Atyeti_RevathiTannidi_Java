package com.carRental.controller;

import com.carRental.dtos.DiscountRequestDTO;
import com.carRental.dtos.DiscountResponseDTO;
import com.carRental.entity.Discount;
import com.carRental.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/discounts")
@RequiredArgsConstructor
public class DiscountController {

    private final DiscountService discountService;

    @PostMapping
    public DiscountResponseDTO createDiscount(@RequestBody DiscountRequestDTO dto) {
        Discount discount = new Discount();
        discount.setCode(dto.getCode());
        discount.setType(dto.getType());
        discount.setValue(dto.getValue());
        discount.setExpiryDate(dto.getExpiryDate());
        return toDTO(discountService.createDiscount(discount));
    }

    @GetMapping("/active")
    public List<DiscountResponseDTO> getActiveDiscounts() {
        return discountService.getActiveDiscounts()
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/apply")
    public double applyDiscount(@RequestParam String code, @RequestParam double amount) {
        return discountService.applyDiscount(code, amount);
    }

    private DiscountResponseDTO toDTO(Discount discount) {
        DiscountResponseDTO dto = new DiscountResponseDTO();
        dto.setId(discount.getId());
        dto.setCode(discount.getCode());
        dto.setType(discount.getType());
        dto.setValue(discount.getValue());
        dto.setExpiryDate(discount.getExpiryDate());
        return dto;
    }
}
