package model;

import java.util.HashMap;
import java.util.Map;

public class TrafficState {
    private static final TrafficState instance = new TrafficState();
    private String currentGreen = "North";
    private final Map<String, String> trafficDensity = new HashMap<>();
    private String emergencyDirection = null;

    private TrafficState() {
        trafficDensity.put("North", "medium");
        trafficDensity.put("East", "low");
        trafficDensity.put("South", "high");
        trafficDensity.put("West", "medium");
    }

    public static TrafficState getInstance() {
        return instance;
    }

    public String getCurrentGreen() {
        return currentGreen;
    }

    public void setCurrentGreen(String currentGreen) {
        this.currentGreen = currentGreen;
    }

    public Map<String, String> getTrafficDensity() {
        return trafficDensity;
    }

    public String getEmergencyDirection() {
        return emergencyDirection;
    }

    public void setEmergencyDirection(String emergencyDirection) {
        this.emergencyDirection = emergencyDirection;
    }
}
