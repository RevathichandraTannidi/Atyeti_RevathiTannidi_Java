package com.org.cabMate.dto;


import com.org.cabMate.model.Rider;
import lombok.Data;

@Data
public class RiderDTO {
    private Long id;
    private String name;
    private double latitude;
    private double longitude;
    private String status;
    public RiderDTO(Rider rider) {
        this.id = rider.getId();
        this.name = rider.getName();
        this.latitude = rider.getLatitude();
        this.longitude = rider.getLongitude();
        this.status = rider.getStatus() != null ? rider.getStatus().name() : null;
    }
}
