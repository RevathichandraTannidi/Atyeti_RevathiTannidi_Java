package org.atyeti.garbagecollector;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GcChurnMixed {
    static final int LONG_LIVED_LISTS = 8;
    static final int LONG_LIVED_CHUNK = 1_000;      // number of arrays per chunk
    static final int LONG_LIVED_SIZE = 1024;        // 1 KB each => ~1 MB per chunk
    static final int BURST_THREADS = Math.max(2, Runtime.getRuntime().availableProcessors());
    static final int BURST_ALLOCATIONS = 2_000_000;
    static final int BURST_MAX_SIZE = 512;          // up to 512 bytes short-lived
    static volatile long blackhole;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Warming up with long-lived allocations...");
        List<List<byte[]>> longLived = new ArrayList<>();
        for (int i = 0; i < LONG_LIVED_LISTS; i++) {
            List<byte[]> chunk = new ArrayList<>(LONG_LIVED_CHUNK);
            for (int j = 0; j < LONG_LIVED_CHUNK; j++) {
                byte[] arr = new byte[LONG_LIVED_SIZE];
                arr[0] = (byte)(i + j);
                chunk.add(arr);
                blackhole += arr[0];
            }
            longLived.add(chunk);
        }
        System.out.println("Long-lived footprint ~" + (LONG_LIVED_LISTS * LONG_LIVED_CHUNK * LONG_LIVED_SIZE / (1024 * 1024)) + " MB");

        // Periodic bursts of short-lived allocations to pressure young gen
        for (int round = 1; round <= 6; round++) {
            System.out.println("Round " + round + " starting bursts...");
            runBurst();
            // Occasionally drop some long-lived references to cause old-gen movement/compaction
            if (round % 2 == 0 && !longLived.isEmpty()) {
                System.out.println("Dropping one long-lived chunk to trigger old-gen reclaim");
                longLived.remove(0);
            }
            Thread.sleep(2000);
        }

        System.out.println("Done. Blackhole=" + blackhole);
        System.out.println("Sleeping 3 minutes for VisualVM observation...");
        Thread.sleep(180_000);
    }

    static void runBurst() throws InterruptedException {
        Thread[] ts = new Thread[BURST_THREADS];
        for (int t = 0; t < BURST_THREADS; t++) {
            ts[t] = new Thread(() -> {
                Random rnd = new Random();
                // Retain a tiny fraction to force some promotions
                List<Object> survivors = new ArrayList<>();
                for (int i = 0; i < BURST_ALLOCATIONS; i++) {
                    int size = 1 + rnd.nextInt(BURST_MAX_SIZE);
                    byte[] b = new byte[size];
                    b[0] = (byte) size;
                    blackhole += b[0];
                    // Keep ~1 in 5000 to survive into old gen
                    if ((i % 5000) == 0) survivors.add(b);
                    // Mix of String/boxing to create different object shapes
                    if ((i & 0x7FFF) == 0) {
                        String s = new String("burst-" + i);
                        Integer x = i;
                        blackhole += s.hashCode() + x;
                    }
                }
                // Slight pause to let GC catch up
                try { Thread.sleep(200); } catch (InterruptedException ignored) {}
            }, "burst-" + t);
            ts[t].start();
        }
        for (Thread t : ts) t.join();
    }
}