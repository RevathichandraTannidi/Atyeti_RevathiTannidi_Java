package org.atyeti.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.atyeti.model.Elevator;
import org.atyeti.model.Request;

import java.util.Comparator;
@RequiredArgsConstructor
@Slf4j
public class RequestDispatcher {

    private final ElevatorManagerService elevatorManager;
    private final ETAService etaService;

    public synchronized void dispatch(Request request) {
        Elevator best = elevatorManager.getElevatorServices().stream()
                .map(ElevatorService::getElevator)
                .min(Comparator.comparingDouble(e -> etaService.calculateETA(e, request)))
                .orElseThrow();

        double eta = etaService.calculateETA(best, request);
        log.info("Elevator {} assigned for [From {} → {}] | ETA: {} sec",
                best.getId(), request.getSourceFloor(), request.getDestinationFloor(), eta);

        elevatorManager.addRequestToElevator(best.getId(), request);
    }
}
