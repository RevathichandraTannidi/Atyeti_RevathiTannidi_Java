package service;

import controller.TrafficLightController;
import java.util.Random;

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
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }


        String direction = dirs[random.nextInt(dirs.length)];
          String density = densities[random.nextInt(densities.length)];
        controller.updateTrafficDensity(direction, density);


            if (random.nextDouble() < 0.1) {
                controller.reportEmergency(direction);
            }
        }
    }
}
