package com.parking.system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntryRequest {

        private String vehicleNumber;
        private String slotType;
        private Long slotId;

}
