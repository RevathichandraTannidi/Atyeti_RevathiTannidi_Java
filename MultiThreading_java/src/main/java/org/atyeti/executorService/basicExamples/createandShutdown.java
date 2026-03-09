package org.atyeti.executorService.basicExamples;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class createandShutdown {
    public static void main(String[] args) {
        ExecutorService ex= Executors.newSingleThreadExecutor();
        try
        {
          ex.submit(()-> System.out.println("hi revathi chandra now im working executor service"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally
        {
            ex.shutdown();
        }
    }
}
