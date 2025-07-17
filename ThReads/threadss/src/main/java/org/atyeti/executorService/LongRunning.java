package org.atyeti.executorService;

import java.util.concurrent.*;
import java.util.Random;
import java.util.logging.Logger;

public class LongRunning {
private static Logger log=Logger.getLogger(LongRunning.class.getName());
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
      private static final ExecutorService taskExecutor = Executors.newCachedThreadPool();
    private static final Random random = new Random();

    public static void main(String[] args) {

        Runnable submitTask = () -> {
        taskExecutor.submit(() -> {

            long start = System.currentTimeMillis();

            int sleepTime = 1 + random.nextInt(6);

            System.out.println(" Task started, will run for " + sleepTime + " sec");

            try {
                TimeUnit.SECONDS.sleep(sleepTime);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            log.warning("thread was interrputed");
                return;
            }

            long duration = System.currentTimeMillis() - start;
            double durationSeconds = duration / 1000.0;

            if (durationSeconds > 4) {
                log.warning(" task took " + durationSeconds + " sec");
            } else {
                System.out.println(" Task completed in " + durationSeconds + " sec");
            }
            System.out.println();
        });
    };

    scheduler.scheduleAtFixedRate(submitTask, 0, 5, TimeUnit.SECONDS);


    scheduler.schedule(() -> {
        System.out.println("Stopping");
        scheduler.shutdown();
        taskExecutor.shutdown();
    }, 40, TimeUnit.SECONDS);
}
}
