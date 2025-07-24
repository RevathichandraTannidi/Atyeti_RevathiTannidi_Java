package com.parking.system.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkingFloorDto {
    private Long id;
    private int floorNumber;
    private List<ParkingSlotDtO> slots;
}
