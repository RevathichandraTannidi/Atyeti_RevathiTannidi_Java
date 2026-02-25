package org.atyeti.garbagecollector;
public class VisualVMEx {
    public static void main(String[] args) throws InterruptedException {
        // Allocate and keep some memory to make it visible in VisualVM
        var list = new java.util.ArrayList<byte[]>();
        for (int i = 0; i < 50; i++) {
            list.add(new byte[2_000_000]); // ~2 MB per chunk
            Thread.sleep(200);             // slow down allocations
        }

        // Do some CPU work to see activity
        long sum = 0;
        for (int i = 0; i < 200_000_000; i++) {
            sum += i;
        }
        System.out.println("Done. Sum = " + sum);

        // Keep the program alive for a while so you can attach VisualVM
        System.out.println("Sleeping for 2 minutes. Attach VisualVM now...");
        Thread.sleep(120_000);
    }
}