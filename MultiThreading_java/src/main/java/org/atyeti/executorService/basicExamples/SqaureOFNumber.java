package org.atyeti.executorService.basicExamples;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SqaureOFNumber {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number : ");
        int n=sc.nextInt();
        ExecutorService ex= Executors.newSingleThreadExecutor();
        Future<Integer> fr=ex.submit(()->n*n);
        System.out.print("result of te square " +fr.get());
        ex.shutdown();
    }
}
