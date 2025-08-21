
package com.org.cabMate.dto;

import com.org.cabMate.model.Driver;
import lombok.Data;

@Data
public class DriverDTO {
    private Long id;
    private String name;
    private String vehicle;
    private double latitude;
    private double longitude;
    private boolean available;
    private double avgRating;

    public DriverDTO(Driver driver) {
        this.id = driver.getId();
        this.name = driver.getName();
        this.vehicle = driver.getVehicle();
        this.latitude = driver.getLatitude();
        this.longitude = driver.getLongitude();
        this.available = driver.isAvailable();
        this.avgRating = driver.getAvgRating();
    }
}
