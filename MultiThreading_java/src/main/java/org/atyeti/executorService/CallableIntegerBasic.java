package org.atyeti.executorService;

import java.util.concurrent.*;

class simpleCallable implements Callable<Integer> {
    int n;

    simpleCallable(int n) {
        this.n = n;
    }

    @Override
    public Integer call() throws Exception {

            return n * n;

    }
}
public class CallableIntegerBasic {
    public static void main(String[] args) {
        ExecutorService ser= Executors.newSingleThreadExecutor();
        try
        {
            simpleCallable s=new simpleCallable(10);
            Future<Integer> f= ser.submit(s);
            System.out.println("result - "+f.get());
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
