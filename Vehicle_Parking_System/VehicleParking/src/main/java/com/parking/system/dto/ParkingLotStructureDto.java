package com.parking.system.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ParkingLotStructureDto {
    private List<ParkingFloorDto> floors;
}
