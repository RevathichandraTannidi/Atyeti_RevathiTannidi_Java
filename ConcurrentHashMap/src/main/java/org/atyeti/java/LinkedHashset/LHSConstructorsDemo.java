package org.atyeti.java.LinkedHashset;

import java.util.*;

public class LHSConstructorsDemo {
    public static void main(String[] args) {
        LinkedHashSet<String> defaultSet = new LinkedHashSet<>();
        defaultSet.add("one"); defaultSet.add("two");
        

        LinkedHashSet<String> capacitySet = new LinkedHashSet<>(128);
        capacitySet.add("x"); capacitySet.add("y");

        LinkedHashSet<String> tunedSet = new LinkedHashSet<>(256, 0.5f);
        tunedSet.add("p"); tunedSet.add("q");

        List<String> list = Arrays.asList("a", "b", "a", "c");
        LinkedHashSet<String> fromCollection = new LinkedHashSet<>(list);

        System.out.println("default     : " + defaultSet);
        System.out.println("capacity    : " + capacitySet);
        System.out.println("tuned       : " + tunedSet);
        System.out.println("fromCollect : " + fromCollection); // [a, b, c]
    }
}

