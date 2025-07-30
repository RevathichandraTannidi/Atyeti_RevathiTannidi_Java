package com.parking.system.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class VehicleDto {
    private String vehicleNumber;
    private String vehicleType;
    private String ownerName;
}

