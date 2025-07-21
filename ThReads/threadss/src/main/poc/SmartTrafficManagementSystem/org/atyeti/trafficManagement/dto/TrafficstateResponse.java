package org.atyeti.trafficManagement.dto;
import java.util.Map;

public class TrafficstateResponse {
    private String currentGreen;
    private String emergencyDirection;
    private Map<String,String> trafficDensity;

    public TrafficstateResponse(String currentGreen, String emergencyDirection, Map<String, String> trafficDensity) {
        this.currentGreen = currentGreen;
        this.emergencyDirection = emergencyDirection;
        this.trafficDensity = trafficDensity;
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

    public Map<String, String> getTrafficDensity() {
        return trafficDensity;
    }

    public void setTrafficDensity(Map<String, String> trafficDensity) {
        this.trafficDensity = trafficDensity;
    }
}
