package com.atyeti.collections.list;

import java.util.List;
import java.util.Spliterator;

public class Splititeratorrr {
    public static void main(String[] args) {
        Spliterator<String> sp = List.of("apple","banana","cherry","date").spliterator();
        int ch = sp.characteristics();

        System.out.println("ORDERED: " + ((ch & Spliterator.ORDERED) != 0));
        System.out.println("SIZED: "   + ((ch & Spliterator.SIZED) != 0));
        System.out.println("SUBSIZED:"+ ((ch & Spliterator.SUBSIZED)!=0));
        System.out.println("NONNULL: " + ((ch & Spliterator.NONNULL) != 0));

    }
}
