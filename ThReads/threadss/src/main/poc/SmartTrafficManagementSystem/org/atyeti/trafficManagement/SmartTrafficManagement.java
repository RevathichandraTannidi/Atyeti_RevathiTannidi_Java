package org.atyeti.trafficManagement;

import org.atyeti.trafficManagement.controller.TrafficLightController;
import org.atyeti.trafficManagement.model.TrafficState;
import org.atyeti.trafficManagement.service.TrafficLight;
import org.atyeti.trafficManagement.service.TrafficSensor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.concurrent.ExecutorService;

@SpringBootApplication
public class SmartTrafficManagement {

    private final ExecutorService executorService;
    private final TrafficLightController controller;
    private final TrafficState state;
    private final TrafficSensor trafficSensor;


    public SmartTrafficManagement(ExecutorService executorService, TrafficLightController controller, TrafficState state, TrafficSensor trafficSensor) {
        this.executorService = executorService;
        this.controller = controller;
        this.state = state;
        this.trafficSensor = trafficSensor;
    }

    public static void main(String[] args) {
        SpringApplication.run(SmartTrafficManagement.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void startServices(ApplicationReadyEvent event) {
        executorService.submit(trafficSensor);
        for (String dir : new String[]{"North", "East", "South", "West"}) {
            executorService.submit(new TrafficLight(dir, controller, state));
        }
    }
}

