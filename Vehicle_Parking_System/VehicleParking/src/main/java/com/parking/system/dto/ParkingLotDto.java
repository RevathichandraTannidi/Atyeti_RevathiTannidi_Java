package com.parking.system.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ParkingLotDto {
    private int slotNumber;
    private String slotType;
    private Boolean available; // changed to Boolean
    private Boolean reserved;  // changed to Boolean
    private String reservedForVehicleNumber;
}

