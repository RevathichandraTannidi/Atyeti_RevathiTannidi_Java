package org.atyeti.trafficManagement.service;

import org.atyeti.trafficManagement.controller.TrafficLightController;
import org.springframework.stereotype.Component;

import java.util.Random;
@Component
public class TrafficSensor implements Runnable {
    private final TrafficLightController controller;
    private final Random random = new Random();
    private final String[] dirs = {"North", "East", "South", "West"};
    private final String[] densities = {"low", "medium", "high"};

    public TrafficSensor(TrafficLightController controller) {
        this.controller = controller;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }


        String direction = dirs[random.nextInt(dirs.length)];
          String density = densities[random.nextInt(densities.length)];
        controller.updateTrafficDensity(direction, density);


            if (random.nextDouble() < 0.50  ) {
                controller.reportEmergency(direction);
            }
        }
    }
}
