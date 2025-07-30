package com.parking.system.dto;

import com.parking.system.model.VehicleType;
import lombok.Data;

@Data
public class TicketRequestDto {
    private Long slotId;
    private String vehiclePlateNumber;
    private String vehicleType;
}