package org.atyeti.java.concurrencyCounter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
public class Example1 {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();


        System.out.println("map size :"+map.size());
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        System.out.println("Map size: " + map.size());

        System.out.println("Value of A: " + map.get("A"));

        map.remove("B");
        System.out.println("After removal map size is: " + map.size());

    }
}