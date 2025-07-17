package controller;

import model.TrafficState;
import java.util.logging.Logger;

public class TrafficLightController {
    private static final Logger logger = Logger.getLogger(TrafficLightController.class.getName());
    private final TrafficState state = TrafficState.getInstance();

    public synchronized void reportEmergency(String direction) {
        state.setEmergencyDirection(direction);
          notifyAll();
    }

    public synchronized void updateTrafficDensity(String direction, String density) {
        state.getTrafficDensity().put(direction, density);
         logger.info("updated traffic density: " + direction + " => " + density);
    }


    public synchronized void allowTraffic(String direction) {
        while (!direction.equals(state.getCurrentGreen()) && !direction.equals(state.getEmergencyDirection())) {
            try {
                wait();
            } catch (InterruptedException e) {
                logger.warning(" Thread interrupted: " + e.getMessage());
            }
        }

        int greenTime = getGreenTime(direction);
        logTrafficStatus(direction);
        logger.info(direction + " is GREEN for " + greenTime + "ms " +
        (direction.equals(state.getEmergencyDirection()) ? "[EMERGENCY]" : "[Density: " + state.getTrafficDensity().get(direction) + "]"));

        try {
            Thread.sleep(greenTime);
        } catch (InterruptedException e) {
            logger.warning("sleep interrupted: " + e.getMessage());
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
                case "high": return 4000;
                case "medium": return 3000;
                case "low": return 2000;
                default: return 3000;
            }
        }

    private void logTrafficStatus(String greenDirection) {
        StringBuilder status = new StringBuilder("[STATUS] ");
        String[] directions = {"North", "East", "South", "West"};
        for (String dir : directions) {
            if (dir.equals(greenDirection)) {
                status.append(dir).append(": GREEN | ");
            } else {
                status.append(dir).append(": RED | ");
            }
        }
        logger.info(status.toString());
    }

    private String getNextDirection(String current) {
        switch (current) {
            case "North": return "East";
            case "East": return "South";
            case "South": return "West";
            case "West": return "North";
            default: return "North";
        }
    }
}
