package org.atyeti.threads;

public class MainThread {
    public static void main(String[] args) {
        CollectorThread collect=new CollectorThread();
        ProcessorThread process=new ProcessorThread();
         ReporterThread repo=new ReporterThread();

         collect.setPriority(Thread.MIN_PRIORITY);
           process.setPriority(Thread.MAX_PRIORITY);
         repo.setPriority(Thread.NORM_PRIORITY);

        collect.start();

        new Thread(() -> {
        try {
         Thread.sleep(2000);

         if (collect.isAlive()) {
               collect.interrupt();
            }

         } catch (InterruptedException e) {
             e.printStackTrace();
            }
                 }).start();

                 try {
                collect.join();
               } catch (InterruptedException e) {
                     e.printStackTrace();
                 }

                process.start();

             try {
             process.join();
             } catch (InterruptedException e) {
                    e.printStackTrace();
                }

        repo.start();

                 try {
                           repo.join();
                 } catch (InterruptedException e) {
                       e.printStackTrace();
                 }


                System.out.println("Collector  alive:  " + collect.isAlive());
                System.out.println("Processor alive :" + process.isAlive());
                System.out.println("Reporter alive:  " + repo.isAlive());

                System.out.println(" threads have completed.");

    }
}
