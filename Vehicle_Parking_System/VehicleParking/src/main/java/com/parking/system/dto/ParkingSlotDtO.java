package com.parking.system.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkingSlotDtO {
    private Long id;
    private String slotNumber;
    private String status;
    private String slotType;
}
