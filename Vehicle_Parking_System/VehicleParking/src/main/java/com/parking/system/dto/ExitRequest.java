package com.parking.system.dto;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExitRequest {
    private String vehicleNumber;
}