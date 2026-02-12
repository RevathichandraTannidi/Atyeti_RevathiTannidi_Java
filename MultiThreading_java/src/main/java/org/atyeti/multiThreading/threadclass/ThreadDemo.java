package org.atyeti.multiThreading.threadclass;

public class ThreadDemo
{
public static void main(String[] args) {
//main thread is responsible for to execute the main method, main method not itself main thread
    Mythread k = new Mythread();  // Thread Instantiation main thread
    k.start(); // starting of thread // child thread -> main thread starts child thread
    for (int i = 0; i < 10; i++) {
        System.out.println("main Thread"); //main thread
    }
}
}
