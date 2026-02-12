package org.atyeti.multiThreading.threadclass;

public class RunnableInterface2 {
    public static void main(String[] args) {
        String userId = "revathi";
        int amount = 42;

        Runnable task = () -> {
            System.out.println("User: " + userId + ", Amount: " + amount);
        };
        new Thread(task).start();


        String orderId="ORD-1001";
        int qty=3;
        new Thread(()-> System.out.println("order Id : " + orderId +", qty :"+qty)).start();


    }
}
