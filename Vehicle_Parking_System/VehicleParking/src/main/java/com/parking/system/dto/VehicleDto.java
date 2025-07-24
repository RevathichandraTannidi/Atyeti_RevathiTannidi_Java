package com.parking.system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDto {
    private String vehicleNumber;
    private String vehicleType;
    private String ownerName;
}

