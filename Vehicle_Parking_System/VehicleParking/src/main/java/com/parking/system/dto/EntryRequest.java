package com.parking.system.dto;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EntryRequest {

        private String vehicleNumber;
        private String slotType;
        private Long slotId;

}
