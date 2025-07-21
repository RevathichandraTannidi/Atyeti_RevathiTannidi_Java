package org.atyeti.trafficManagement.service;

import org.atyeti.trafficManagement.controller.TrafficLightController;
import org.atyeti.trafficManagement.model.TrafficState;

public class TrafficLight implements Runnable {
    private final TrafficLightController controller;
    private final String direction;
    private final TrafficState state ;

    public TrafficLight(String direction, TrafficLightController controller, TrafficState state) {
        this.direction = direction;
        this.controller = controller;
        this.state = state;
    }

    @Override
    public void run() {
        while (true) {
            String current = state.getCurrentGreen();
            if (direction.equals(current) || direction.equals(state.getEmergencyDirection())) {
                controller.allowTraffic(direction);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
