package org.atyeti.executorService.basicExamples;



import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class InvokeAllSquares {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(3);
        List<Callable<Integer>> li = new ArrayList<>();
        try
        {
            for(int i=1;i<=100;i++)
            {
                int finalI = i;
                li.add(()-> finalI * finalI);
            }
List<Future<Integer>> futures=ex.invokeAll(li);
            for(int i=1;i<=100;i++) {
                System.out.println(i+ " sqaure of the numbers " + futures.get(i-1).get());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            ex.shutdown();
        }

    }
}

