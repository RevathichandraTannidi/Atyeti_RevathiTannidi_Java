package org.atyeti.controller;

import lombok.extern.slf4j.Slf4j;
import org.atyeti.model.Request;
import org.atyeti.service.ElevatorService;

import java.util.List;
import java.util.Random;

@Slf4j
public class ElevatorController {

    private final List<ElevatorService> elevators;
    private final Random random = new Random();

    public ElevatorController(List<ElevatorService> elevators) {
        this.elevators = elevators;
    }


    public synchronized void handleRequest(int from, int to) {
        ElevatorService randomElevator = elevators.get(random.nextInt(elevators.size()));
        assignRequest(randomElevator, from, to);
    }


    public synchronized ElevatorService handleRequestAndReturnElevator(int from, int to) {
        ElevatorService randomElevator = elevators.get(random.nextInt(elevators.size()));
        assignRequest(randomElevator, from, to);
        return randomElevator;
    }


    private void assignRequest(ElevatorService elevator, int from, int to) {
        double eta = Math.abs(elevator.getElevator().getCurrentFloor() - from) * 0.5;
        log.info("[{}] Randomly assigning Elevator {} for [From {} → {}] | ETA: {} sec",
                java.time.LocalTime.now().withNano(0),
                elevator.getElevator().getId(), from, to, eta);

        elevator.addRequest(new Request(from, to));
    }
}
