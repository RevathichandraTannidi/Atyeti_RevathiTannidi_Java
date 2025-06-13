package com.atyeti.collections.list;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Iteratorss {



        public static void main(String[] args) throws InterruptedException {
            List<String> items = new ArrayList<>(List.of("Alpha", "Bravo", "Charlie", "Delta", "Echo"));


            System.out.println("Forward iteration:");
            ListIterator<String> litr = items.listIterator();
            while (litr.hasNext()) {
                System.out.println("nextIndex=" + litr.nextIndex() + ", element=" + litr.next());
            }


            System.out.println("\nBackward iteration:");
            while (litr.hasPrevious()) {
                System.out.println("previousIndex=" + litr.previousIndex() + ", element=" + litr.previous());
            }


            System.out.println("\nParallel processing with Spliterator:");
            Spliterator<String> sp1 = items.spliterator();
            Spliterator<String> sp2 = sp1.trySplit();

            ExecutorService exec = Executors.newFixedThreadPool(2);
            exec.submit(() -> sp2.forEachRemaining(e ->
                    System.out.println(Thread.currentThread().getName() + ": " + e + " (len " + e.length() + ")")
            ));
            exec.submit(() -> sp1.forEachRemaining(e ->
                    System.out.println(Thread.currentThread().getName() + ": " + e + " (len " + e.length() + ")")
            ));

            exec.shutdown();
            exec.awaitTermination(5, TimeUnit.SECONDS);
        }
    }


