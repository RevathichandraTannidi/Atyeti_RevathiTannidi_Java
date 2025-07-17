package service;

import controller.TrafficLightController;
import model.TrafficState;

public class TrafficLight implements Runnable {
    private final TrafficLightController controller;
    private final String direction;
    private final TrafficState state = TrafficState.getInstance();

    public TrafficLight(String direction, TrafficLightController controller) {
        this.direction = direction;
        this.controller = controller;
    }

    @Override
    public void run() {
        while (true) {
            String current = state.getCurrentGreen();
            if (direction.equals(current) || direction.equals(state.getEmergencyDirection())) {
                controller.allowTraffic(direction);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
