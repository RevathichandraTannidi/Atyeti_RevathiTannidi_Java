package collections_set_list_queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class Queue1 {
    public static void main(String[] args) throws InterruptedException {
        Queue<Integer> q = new PriorityQueue<>();
        q.add(3);
        q.add(1);
        q.add(2);
        Thread.sleep(100000);
        System.out.println(q);
        
    }
}
