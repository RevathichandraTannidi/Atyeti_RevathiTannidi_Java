package org.atyeti.service;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.atyeti.model.Elevator;
import org.atyeti.model.ElevatorState;
import org.atyeti.model.Request;

import java.util.*;
import java.util.concurrent.*;

@Slf4j
public class ElevatorManagerService {

    @Getter
    private final Map<Integer, ElevatorService> elevators = new ConcurrentHashMap<>();

    public ElevatorManagerService(int numElevators) {
        for (int i = 1; i <= numElevators; i++) {
            Elevator elevator = new Elevator(i, 0, ElevatorState.IDLE);
            ElevatorService service = new ElevatorService(elevator);
            elevators.put(i, service);
        }
    }

    public void startAllElevators() {
        ExecutorService pool = Executors.newFixedThreadPool(elevators.size());
        elevators.values().forEach(pool::execute);
        log.info(" Started {} elevators.", elevators.size());
    }

    public void addRequestToElevator(int elevatorId, Request request) {
        ElevatorService service = elevators.get(elevatorId);
        if (service != null) {
            service.addRequest(request);
            log.info("Added request [From {} → {}] to Elevator {}.",
                    request.getSourceFloor(), request.getDestinationFloor(), elevatorId);
        } else {
            log.warn("Elevator {} not found!", elevatorId);
        }
    }

    public Collection<ElevatorService> getElevatorServices() {
        return elevators.values();
    }
}
