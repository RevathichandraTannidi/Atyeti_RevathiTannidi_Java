package com.atyeti.collections.list.linkedList;

import java.util.*;

public class LinkedListVsArrayList {
    public static void main(String[] args) {
        List<Integer> linked = new LinkedList<>();
        List<Integer> arrayli = new ArrayList<>();

        long startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            linked.add(0, i);
        }
        long endTime = System.nanoTime();
        System.out.println("LinkedList add at front: " + (endTime - startTime) / 1e6 + "in ms");

        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            arrayli.add(0, i);
        }
        endTime = System.nanoTime();
        System.out.println("ArrayList add : " + (endTime - startTime) / 1e6 + " in ms");
    }
}