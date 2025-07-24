package com.parking.system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketDto {
    private Long id;
    private String ticketNumber;
    private String vehicleNumber;
    private String slotNumber;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private Double totalAmount;
}

