package org.atyeti.executorService.basicExamples;

import java.util.concurrent.*;

public class CallableReturn10 {
    public static void main(String[] args) {
        ExecutorService ser= Executors.newSingleThreadExecutor();
        try
        {
            Callable<Integer> cl=()->10;
            Future<Integer> fr= ser.submit(cl);
            System.out.println("res - "+fr.get());
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            ser.shutdown();
        }

    }
}
