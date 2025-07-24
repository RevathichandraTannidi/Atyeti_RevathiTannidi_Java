package com.parking.system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkingLotDto {
    private Long id;
    private String name;
    private String location;
    private List<ParkingFloorDto> floors;
}
