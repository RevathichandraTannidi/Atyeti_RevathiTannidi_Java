package org.atyeti.executorService.basicExamples;

import java.util.concurrent.*;

public class TimeoutExceptionFuture {
    public static void main(String[] args)  {
        ExecutorService ex= Executors.newSingleThreadExecutor();
        try {
            Future<String> fr = ex.submit(() ->
            {
                Thread.sleep(2000);
                return "done submitted";
            });
            System.out.println(fr.get(2,TimeUnit.SECONDS));

        }
        catch (ExecutionException| InterruptedException| TimeoutException e)
        {
            System.out.println("Timed out");
        }finally {
            ex.shutdown();
        }

    }
}
