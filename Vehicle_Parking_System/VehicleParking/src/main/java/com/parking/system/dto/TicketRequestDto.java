package com.parking.system.dto;


import lombok.Data;

@Data
public class TicketRequestDto {
    private String vehiclePlateNumber;
    private String slotType;
    private Long slotId;
}
