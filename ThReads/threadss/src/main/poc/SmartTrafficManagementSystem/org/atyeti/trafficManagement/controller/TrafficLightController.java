package org.atyeti.trafficManagement.controller;

import org.springframework.stereotype.Component;

import org.atyeti.trafficManagement.model.TrafficState;
import java.util.logging.Logger;

@Component
public class TrafficLightController {
    private static final Logger logger = Logger.getLogger(TrafficLightController.class.getName());

    private final TrafficState state;

    public TrafficLightController(TrafficState state) {
        this.state = state;
    }

    public synchronized void reportEmergency(String direction) {
        state.setEmergencyDirection(direction);
        logger.info("EMERGENCY reported for: " + direction);
        notifyAll();
    }

    public synchronized void updateTrafficDensity(String direction, String density) {
        state.getTrafficDensity().put(direction, density);
        logger.info("Updated traffic density: " + direction + " → " + density);
    }

    public synchronized void allowTraffic(String direction) {
        while (!direction.equals(state.getCurrentGreen())
                && !direction.equals(state.getEmergencyDirection())) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                logger.warning("Interrupted while waiting: " + e.getMessage());
                return;
            }
        }

        int greenTime = getGreenTime(direction);
        logTrafficStatus(direction);
        logger.info(direction + " GREEN for " + greenTime + "ms " +
                (direction.equals(state.getEmergencyDirection()) ? "[EMERGENCY]"
                        : "[Density: " + state.getTrafficDensity().get(direction) + "]"));

        try {
            Thread.sleep(greenTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.warning("Sleep interrupted: " + e.getMessage());
        }

        logger.info(direction + " is now RED.");

        if (direction.equals(state.getEmergencyDirection())) {
            state.setEmergencyDirection(null);
        }

        state.setCurrentGreen(getNextDirection(direction));
        notifyAll();
    }

    private int getGreenTime(String direction) {
        switch (state.getTrafficDensity().getOrDefault(direction, "medium")) {
            case "high":
                return 4000;
            case "low":
                return 2000;
            default:
                return 3000;
        }
    }

    private void logTrafficStatus(String active) {
        StringBuilder sb = new StringBuilder("[STATUS] ");
        for (String dir : new String[] {"North", "East", "South", "West"}) {
            sb.append(dir).append(dir.equals(active) ? ": GREEN | " : ": RED | ");
        }
        logger.info(sb.toString());
    }

    private String getNextDirection(String current) {
        switch (current) {
            case "North":
                return "East";
            case "East":
                return "South";
            case "South":
                return "West";
            case "West":
                return "North";
            default:
                return "North";
        }
    }

    public TrafficState getState() {
        return state;
    }
}
