package main;

import controller.TrafficLightController;
import service.FileInput;
import service.TrafficSensor;

import service.TrafficLight;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SmartTrafficManagement {
    public static void main(String[] args) {
        TrafficLightController controller = new TrafficLightController();
        ExecutorService executor = Executors.newFixedThreadPool(6);

          executor.execute(new TrafficSensor(controller));
        executor.execute(new FileInput("C:\\Users\\RevathiTannidi\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_RevathiTannidi_Java\\ThReads\\threadss\\src\\main\\resources\\traffic_data.txt", controller));

          executor.execute(new TrafficLight("North", controller));
        executor.execute(new TrafficLight("East", controller));
         executor.execute(new TrafficLight("South", controller));
        executor.execute(new TrafficLight("West", controller));

    }
}
