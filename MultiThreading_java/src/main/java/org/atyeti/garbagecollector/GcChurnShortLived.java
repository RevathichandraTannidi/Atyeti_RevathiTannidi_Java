package org.atyeti.garbagecollector;
import java.util.Random;

public class GcChurnShortLived {
    static final int THREADS = Math.max(2, Runtime.getRuntime().availableProcessors());
    static final int ALLOCATIONS_PER_THREAD = 10_000_000;
    static final int MAX_ARRAY = 64; // 1–64 bytes per alloc
    static volatile long blackhole;  // prevent JIT from eliminating work

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting GC churn (short-lived objects) with " + THREADS + " threads");
        Thread[] ts = new Thread[THREADS];
        for (int t = 0; t < THREADS; t++) {
            ts[t] = new Thread(() -> {
                Random rnd = new Random();
                for (int i = 0; i < ALLOCATIONS_PER_THREAD; i++) {
                    // Create small temp arrays (die quickly)
                    byte[] a = new byte[1 + rnd.nextInt(MAX_ARRAY)];
                    // Touch a few bytes to ensure allocation is ‘real’
                    a[0] = (byte) rnd.nextInt(256);
                    blackhole += a[0];
                    // Occasionally create short-lived objects of different types
                    if ((i & 0x3FF) == 0) {
                        String s = new String("temp" + i); // new String forces allocation
                        blackhole += s.hashCode();
                        Integer x = i; // boxing creates objects intermittently
                        blackhole += x;
                    }
                }
            }, "alloc-" + t);
            ts[t].start();
        }
        for (Thread t : ts) t.join();
        System.out.println("Done. Blackhole=" + blackhole);
        // Keep alive for VisualVM attach
        System.out.println("Sleeping for 2 minutes to observe in VisualVM...");
        Thread.sleep(120_000);
    }
}
