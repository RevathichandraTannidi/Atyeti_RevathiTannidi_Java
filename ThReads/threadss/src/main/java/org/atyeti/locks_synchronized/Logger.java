package org.atyeti.locks_synchronized;

import java.util.concurrent.locks.ReentrantLock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Logger {
    private final ReentrantLock lock = new ReentrantLock();
     private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

    public void log(String message) {
         lock.lock();
        try {
            String time = LocalDateTime.now().format(formatter);
              String threadName = Thread.currentThread().getName();
            System.out.println("[" + time + "] [" + threadName + "]: " + message);
        } finally {
            lock.unlock();
        }
    }
}
