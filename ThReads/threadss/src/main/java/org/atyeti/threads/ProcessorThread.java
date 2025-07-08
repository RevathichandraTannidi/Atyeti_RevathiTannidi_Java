package org.atyeti.threads;

public class ProcessorThread  extends  Thread{

    public void run() {
        setName("processor  Thread");
        for (int i = 1; i <= 5; i++) {
            try {
                System.out.println(getName() + " - Iteration " + i);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrupted during sleep.");
                return;
            }
        }
    }

}
