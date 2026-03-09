package org.atyeti.executorService.basicExamples;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class NSqaureOfNumbers {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(3);
            List<Future<Integer>> li = new ArrayList<>();
            try
            {
                for(int i=1;i<=100;i++)
                {
                    int finalI = i;
                    li.add(ex.submit(()-> finalI * finalI));
                }
                for(int i=1;i<=100;i++) {
                    System.out.println(i+ "sqaure of the numbers " +li.get(i-1).get());
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
finally {
                ex.shutdown();
            }

    }
}
