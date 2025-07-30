package com.parking.system.dto;

import lombok.*;

import java.util.List;

@Data
public class ParkingFloorDto {
    private int floorNumber;
    private List<ParkingLotDto> slots;
}