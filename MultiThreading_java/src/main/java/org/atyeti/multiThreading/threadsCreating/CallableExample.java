package org.atyeti.multiThreading.threadsCreating;

import java.util.concurrent.*;

class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "Callable result";
    }
}

public class CallableExample {
    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newSingleThreadExecutor();

        Future<String> future = service.submit(new MyCallable());

        System.out.println("Result: " + future.get());  // returns value

        service.shutdown();
    }
}
