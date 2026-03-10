package org.atyeti.java.practice;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;


public class Priorty {
    public static void main(String[] args) {
        PriorityQueue<Integer> pi=new PriorityQueue<>(1);
        pi.add(10);
        pi.add(20);
        pi.add(30);

        System.out.println(pi);

        Queue<Integer> qi=new ArrayDeque<>();
        qi.add(null);
        qi.add(20);
        qi.add(30);
        System.out.println(qi);
        TreeSet<String> tr=new TreeSet<>();
        tr.add(null);
        tr.add("Abs");
        System.out.println(tr);

    }
}
