package org.atyeti.service;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.atyeti.model.Elevator;
import org.atyeti.model.ElevatorState;
import org.atyeti.model.Request;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

@Slf4j
@Getter
public class ElevatorService implements Runnable {

    private final Elevator elevator;
    private final BlockingQueue<Request> requests = new LinkedBlockingQueue<>();
    private volatile boolean running = true;
    private Thread thread;

    public ElevatorService(Elevator elevator) {
        this.elevator = elevator;
    }


    public void start() {
        thread = new Thread(this, "Elevator-" + elevator.getId());
        thread.start();
    }

    public void addRequest(Request request) {
        requests.offer(request);
    }


    public void stopService() {
        running = false;


        requests.offer(new Request(elevator.getCurrentFloor(), elevator.getCurrentFloor()));

        if (thread != null) {
            thread.interrupt();
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        requests.clear();
        log.info("Elevator {} service stopping...", elevator.getId());
    }

    @Override
    public void run() {
        while (running) {
            try {

                Request req = requests.poll(500, TimeUnit.MILLISECONDS);
                if (req == null) continue;

                if (!running) break;

                moveTo(req.getSourceFloor());
                moveTo(req.getDestinationFloor());

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.info("Elevator {} interrupted.", elevator.getId());
                break;
            }
        }
        log.info("Elevator {} stopped.", elevator.getId());
    }

    private void moveTo(int floor) throws InterruptedException {
        if (!running) return;

        int current = elevator.getCurrentFloor();

        if (floor > current) {
            elevator.setState(ElevatorState.MOVING_UP);
        } else if (floor < current) {
            elevator.setState(ElevatorState.MOVING_DOWN);
        } else {
            elevator.setState(ElevatorState.IDLE);
            return;
        }

        log.info("Elevator {} moving from floor {} to floor {}", elevator.getId(), current, floor);

        int travelTime = Math.abs(floor - current) * 500;
        int steps = travelTime / 100;

        for (int i = 0; i < steps && running; i++) {
            Thread.sleep(100);
        }

        if (!running) {
            log.info("Elevator {} stopped mid-journey.", elevator.getId());
            return;
        }

        elevator.setCurrentFloor(floor);
        log.info("Elevator {} reached floor {}", elevator.getId(), floor);
        elevator.setState(ElevatorState.IDLE);
    }
}
