package com.carRental.controller;

import com.carRental.dtos.InvoiceRequestDTO;
import com.carRental.dtos.InvoiceResponseDTO;
import com.carRental.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/invoices")
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceService invoiceService;

    @PostMapping
    public InvoiceResponseDTO createInvoice(@RequestBody InvoiceRequestDTO dto) {
        return invoiceService.generateInvoice(dto); // Already returns DTO
    }

    @GetMapping
    public List<InvoiceResponseDTO> getAllInvoices() {
        return invoiceService.getAllInvoices(); // Already returns List<DTO>
    }

    @GetMapping("/range")
    public List<InvoiceResponseDTO> getInvoicesBetween(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        return invoiceService.getInvoicesBetween(start, end);
    }
}
