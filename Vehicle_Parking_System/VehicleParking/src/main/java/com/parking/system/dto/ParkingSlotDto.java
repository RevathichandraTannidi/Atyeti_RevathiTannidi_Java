package com.parking.system.dto;

import com.parking.system.model.SlotType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter @Setter
@Data
public class ParkingSlotDto {
    private Long id;
    private int slotNumber;
    private SlotType slotType;
    private Boolean isAvailable;
    private Boolean isReserved;
    private String reservedForVehicleNumber;
    private Long floorId;
    private List<ParkingFloorDto> floors= new ArrayList<>();
}


