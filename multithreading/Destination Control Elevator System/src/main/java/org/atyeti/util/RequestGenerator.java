package org.atyeti.util;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.atyeti.model.Request;
import java.util.Random;

@Slf4j
@RequiredArgsConstructor
public class RequestGenerator implements Runnable {

    private final org.atyeti.controller.ElevatorController controller;
    private final int totalFloors;
    private final int intervalMillis;
    private volatile boolean running = true;

    private final Random random = new Random();

    @Override
    public void run() {
        log.info(" Request Generator started — generating random requests every {} ms", intervalMillis);

        while (running) {
            try {
                int from = random.nextInt(totalFloors) + 1;
                int to;
                do {
                    to = random.nextInt(totalFloors) + 1;
                } while (to == from);

                Request request = new Request(from, to);
                controller.handleRequest(from, to);

                Thread.sleep(intervalMillis);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.warn("Request Generator stopped.");
                break;
            }
        }
    }

    public void stop() {
        running = false;
    }
}
