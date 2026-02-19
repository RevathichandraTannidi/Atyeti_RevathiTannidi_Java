package org.atyeti.multiThreading.itc;

public class Job {

    private boolean completed = false;

    public synchronized void doWork() {

        System.out.println("Worker: Processing job...");
        try { Thread.sleep(2000); } catch (Exception e) {}

        completed = true;
        System.out.println("Worker: Job completed");

        notifyAll();
    }

    public synchronized void waitForCompletion()
            throws InterruptedException {

        while (!completed) {
            System.out.println("Main thread waiting...");
            wait();
        }

        System.out.println("Main thread resumes: job done");
    }

    public static void main(String[] args) throws InterruptedException {

        Job job = new Job();

        Thread worker = new Thread(() -> job.doWork());

        worker.start();

        job.waitForCompletion();
    }
}

