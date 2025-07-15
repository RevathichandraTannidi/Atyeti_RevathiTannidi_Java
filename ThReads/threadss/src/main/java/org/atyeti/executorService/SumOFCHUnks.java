package org.atyeti.executorService;

import java.util.Arrays;
import java.util.Random;

import static org.atyeti.executorService.ParallelAraysSum.parallelSum;

public class SumOFCHUnks {

    public static void main(String[] args) throws Exception {
        int size = 10_000_000;
        int[] arr = new Random().ints(size, 0, 100).toArray();

        long t0 = System.currentTimeMillis();
        long sum1 = Arrays.stream(arr).asLongStream().sum();
        long t1 = System.currentTimeMillis();

        long sum2 = parallelSum(arr);
        long t2 = System.currentTimeMillis();

        System.out.printf("Serial sum = %d (time = %d ms)%n", sum1, t1 - t0);
        System.out.printf("Parallel sum = %d (time = %d ms)%n", sum2, t2 - t1);
    }
}
//Goal:
//Given a large array of integers, divide it into chunks, compute the sum of each chunk in parallel
// using ExecutorService, and combine the results to get the total sum.