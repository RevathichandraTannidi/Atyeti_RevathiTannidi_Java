package com.atyeti.collections.list.arrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class TestSpliterator {
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>(List.of("Apple", "Mango", "Banana", "Grapes","orange","rum"));
        Spliterator<String> sp1 = fruits.spliterator();// from bck to front
        Spliterator<String> sp2 = sp1.trySplit();// to enable parallel processing by dividing a data  into two parts.

                System.out.println("First half:");
        sp1.forEachRemaining(System.out::println);

        System.out.println("Second half:");
        if (sp2 != null) sp2.forEachRemaining(System.out::println);
    }
}
