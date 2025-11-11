package org.atyeti.service;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.atyeti.model.Elevator;
import org.atyeti.model.ElevatorState;
import org.atyeti.model.Request;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Slf4j
@Getter
public class ElevatorService implements Runnable {

    private final Elevator elevator;
    private final BlockingQueue<Request> requests = new LinkedBlockingQueue<>();

    public ElevatorService(Elevator elevator) {
        this.elevator = elevator;
    }

    public void addRequest(Request request) {
        requests.offer(request);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Request req = requests.take();
                moveTo(req.getSourceFloor());
                moveTo(req.getDestinationFloor());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.warn("Elevator {} shutting down.", elevator.getId());
                break;
            }
        }
    }

    private void moveTo(int floor) throws InterruptedException {
        int current = elevator.getCurrentFloor();

        if (floor > current) {
            elevator.setState(ElevatorState.MOVING_UP);
        } else if (floor < current) {
            elevator.setState(ElevatorState.MOVING_DOWN);
        } else {
            elevator.setState(ElevatorState.IDLE);
        }

        log.info("Elevator {} moving from floor {} to floor {}", elevator.getId(), current, floor);
        Thread.sleep(Math.abs(floor - current) * 500L);
        elevator.setCurrentFloor(floor);
        log.info(" Elevator {} reached floor {}", elevator.getId(), floor);
        elevator.setState(ElevatorState.IDLE);
    }
}
