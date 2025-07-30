package com.parking.system.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class TicketDto {
    private Long id;
    private String ticketNumber;
    private String vehicleNumber;
    private String slotNumber;
    private String vehicleType;
    private String plateNumber;
    private Long slotId;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private Double totalAmount;

}

