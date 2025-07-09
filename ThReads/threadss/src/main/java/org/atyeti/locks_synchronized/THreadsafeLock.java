package org.atyeti.locks_synchronized;

public class THreadsafeLock {
    public static void main(String[] args) {
        Logger logger = new Logger();

        Runnable loggingTask = () -> {
            for (int i = 1; i <= 5; i++) {
                logger.log("Log message " + i);
            try {
                Thread.sleep((long) (Math.random() * 100));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        Thread t1 = new Thread(loggingTask, "Thread-1");
        Thread t2 = new Thread(loggingTask, "Thread-2");
        Thread t3 = new Thread(loggingTask, "Thread-3");
        t1.start();
        t2.start();
        t3.start();

    }
}
