package org.atyeti.service;

import org.atyeti.model.Elevator;
import org.atyeti.model.Request;

public class ETAService {
    public double calculateETA(Elevator elevator, Request request) {
        return Math.abs(elevator.getCurrentFloor() - request.getSourceFloor()) * 0.7;
    }
}
