package org.atyeti;

import lombok.extern.slf4j.Slf4j;
import org.atyeti.controller.ElevatorController;
import org.atyeti.model.Elevator;
import org.atyeti.model.ElevatorState;
import org.atyeti.model.FloorLabel;
import org.atyeti.service.ElevatorService;
import org.atyeti.util.RequestGenerator;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {

    private static final int NUM_ELEVATORS = 6;
    private static final int MAX_FLOOR = 15;

    public static void main(String[] args) {
        log.info(" Elevator Simulation System Starting...");


        List<ElevatorService> elevatorServices = new ArrayList<>();
        for (int i = 1; i <= NUM_ELEVATORS; i++) {
            Elevator elevator = new Elevator(i, 0, ElevatorState.IDLE);
            elevatorServices.add(new ElevatorService(elevator));
            log.info("Initialized Elevator {} → Floor: {} ({}), State: {}",
                    i, 0, FloorLabel.getLabelByNumber(0), ElevatorState.IDLE);
        }


        ExecutorService elevatorExecutor = Executors.newFixedThreadPool(NUM_ELEVATORS);
        elevatorServices.forEach(elevatorExecutor::execute);

        ElevatorController controller = new ElevatorController(elevatorServices);
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("\n=== Elevator Simulation ===");
            System.out.println("Floors available:");
            System.out.println(" B2, B1, G,");
            System.out.println(" 1,2,3,");
            System.out.println(" 4,5,6,");
            System.out.println(" 7,8,9,");
            System.out.println(" 10,11,12,");
            System.out.println(" 13,14,15");
            System.out.println("\n1. Manual Mode");
            System.out.println("2. Automatic Mode (Random Requests)");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int mode;
            try {
                mode = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }

            switch (mode) {
                case 1 -> runManualMode(controller, scanner);
                case 2 -> {runAutoMode(controller, MAX_FLOOR);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                System.out.flush();
            }
                case 3 -> {
                    log.info(" Exiting Elevator Simulation...");
                    controller.getElevatorServices().forEach(ElevatorService::stopService);
                    elevatorExecutor.shutdownNow();
                    scanner.close();
                    log.info(" Simulation ended.");
                    return;
                }
                default -> System.out.println(" Invalid choice. Try again.");
            }
        }
    }


    private static void runManualMode(ElevatorController controller, Scanner scanner) {
        System.out.println("\n--- Manual Mode Started ---");
        System.out.println("Enter floors as: B2, B1, G, or 1–15.");
        System.out.println("Type 'exit' to quit.");

        while (true) {
            System.out.print("\nEnter source floor: ");
            String srcInput = scanner.next();
            if (srcInput.equalsIgnoreCase("exit")) break;

            Integer source = parseFloorInput(srcInput);
            if (source == null || !FloorLabel.isValid(source)) {
                System.out.println(" Invalid floor! Try again.");
                continue;
            }

            System.out.print("Enter destination floor: ");
            String destInput = scanner.next();
            if (destInput.equalsIgnoreCase("exit")) break;

            Integer destination = parseFloorInput(destInput);
            if (destination == null || !FloorLabel.isValid(destination)) {
                System.out.println("Invalid floor Try again.");
                continue;
            }

            if (source.equals(destination)) {
                System.out.println(" Source and destination cannot be same!");
                continue;
            }

            ElevatorService assignedElevator = controller.handleRequestAndReturnElevator(source, destination);
            System.out.println(" Request added successfully!");
            System.out.println(" Waiting for Elevator " + assignedElevator.getElevator().getId());


            while (assignedElevator.getElevator().getState() != ElevatorState.IDLE) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            System.out.println(" Elevator " + assignedElevator.getElevator().getId() +"is reached");
            System.out.print("Add another request? (yes/no): ");
            System.out.flush();
            String next = scanner.next();
            if (next.equalsIgnoreCase("no")) break;
        }

        System.out.println("\n Manual mode ended.");
    }


    private static void runAutoMode(ElevatorController controller, int totalFloors) {
        RequestGenerator generator = new RequestGenerator(controller, totalFloors, 3000);
        Thread generatorThread = new Thread(generator);
        generatorThread.start();

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        generator.stop();
        generatorThread.interrupt();
        try {
            generatorThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        controller.getElevatorServices().forEach(ElevatorService::stopService);
        System.out.println(" Automatic mode stopped after simulation.");
    }


    private static Integer parseFloorInput(String input) {
        return switch (input.toUpperCase()) {
            case "B2" -> -2;
            case "B1" -> -1;
            case "G" -> 0;
            default -> {
                try {
                    yield Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    yield null;
                }
            }
        };
    }
}
