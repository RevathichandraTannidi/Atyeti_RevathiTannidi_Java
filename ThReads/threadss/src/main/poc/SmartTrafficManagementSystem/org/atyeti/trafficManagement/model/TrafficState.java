package org.atyeti.trafficManagement.model;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Component
public class TrafficState {
    private volatile String currentGreen = "North";
    private volatile String emergencyDirection = null;
    private final ConcurrentMap<String, String> trafficDensity = new ConcurrentHashMap<>(
            Map.of("North", "medium", "East", "medium", "South", "medium", "West", "medium")
    );

    public ConcurrentMap<String, String> getTrafficDensity() {
        return trafficDensity;
    }

    public String getCurrentGreen() {
        return currentGreen;
    }

    public void setCurrentGreen(String currentGreen) {
        this.currentGreen = currentGreen;
    }

    public String getEmergencyDirection() {
        return emergencyDirection;
    }

    public void setEmergencyDirection(String emergencyDirection) {
        this.emergencyDirection = emergencyDirection;
    }
}
