package com.carRental.service;

import com.carRental.dtos.InvoiceRequestDTO;
import com.carRental.dtos.InvoiceResponseDTO;
import com.carRental.entity.Invoice;
import com.carRental.entity.Rental;
import com.carRental.exceptionhandling.BadRequestException;
import com.carRental.exceptionhandling.ResourceNotFoundException;
import com.carRental.repository.InvoiceRepository;
import com.carRental.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final RentalRepository rentalRepository;



    public InvoiceResponseDTO generateInvoice(InvoiceRequestDTO dto) {
        if (dto.getAmount() <= 0) {
            throw new BadRequestException("Invoice amount must be greater than zero");
        }

        Rental rental = rentalRepository.findById(dto.getRentalId())
                .orElseThrow(() -> new ResourceNotFoundException("Rental not found with id: " + dto.getRentalId()));

        Invoice invoice = new Invoice();
        invoice.setRental(rental);
        invoice.setAmount(dto.getAmount());
        invoice.setGeneratedAt(LocalDateTime.now());

        Invoice saved = invoiceRepository.save(invoice);
        return toDTO(saved);
    }


    public List<InvoiceResponseDTO> getInvoicesBetween(LocalDateTime start, LocalDateTime end) {
        if (start == null || end == null) {
            throw new BadRequestException("Start and end dates must be provided");
        }
        if (start.isAfter(end)) {
            throw new BadRequestException("Start date cannot be after end date");
        }

        List<Invoice> invoices = invoiceRepository.findByGeneratedAtBetween(start, end);
        if (invoices.isEmpty()) {
            throw new ResourceNotFoundException("No invoices found between " + start + " and " + end);
        }
        return invoices.stream().map(this::toDTO).collect(Collectors.toList());
    }


    public List<InvoiceResponseDTO> getAllInvoices() {
        return invoiceRepository.findAll()
                .stream().map(this::toDTO).collect(Collectors.toList());
    }


    private InvoiceResponseDTO toDTO(Invoice invoice) {
        InvoiceResponseDTO dto = new InvoiceResponseDTO();
        dto.setId(invoice.getId());
        dto.setRentalId(invoice.getRental() != null ? invoice.getRental().getId() : null);
        dto.setCarId(invoice.getRental() != null ? invoice.getRental().getCar().getId() : null);
        dto.setAmount(invoice.getAmount());
        dto.setGeneratedAt(invoice.getGeneratedAt());
        return dto;
    }
}
