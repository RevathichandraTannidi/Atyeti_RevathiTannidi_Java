package org.atyeti.executorService;
import java.util.*;
import java.util.concurrent.*;
public class ParallelAraysSum {
    public static long parallelSum(int[] array) throws Exception {
        int numThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        List<Future<Long>> futures = new ArrayList<>();
        int chunkSize = (array.length + numThreads - 1) / numThreads;

        for (int t = 0; t < numThreads; t++) {
            int start = t * chunkSize;
            int end = Math.min(start + chunkSize, array.length);
            if (start >= end) break;
            futures.add(executor.submit(new SumTask(array, start, end)));
        }

        long total = 0;
        for (Future<Long> f : futures) {
            total += f.get();
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
        return total;
    }
}
