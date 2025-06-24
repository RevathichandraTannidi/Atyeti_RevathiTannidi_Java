package com.atyeti.collections.list.linkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class SomeRareMethodsLinkedList {
    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>(List.of("A", "B", "C"));

        for (Iterator<String> it = list.descendingIterator(); it.hasNext(); )
            System.out.print(it.next() + " ");
        System.out.println();


        ListIterator<String> it = list.listIterator(1);
        it.add("X");
        System.out.println(" add 'X' at index 1: " + list);


        LinkedList<Integer> original = new LinkedList<>(List.of(1, 2, 3));
        System.out.println("original: "  + original);

        LinkedList<Integer> copy = (LinkedList<Integer>) original.clone();
        System.out.println("copy: " + copy);


        LinkedList<Integer> ll = new LinkedList<>(List.of(1, 2, 3, 4));
        List<Integer> rev = ll.reversed();
        System.out.println("reversed list: " + rev);

        ll.addFirst(0);
        System.out.println("After add first : " + rev);

        list.add("A");
        list.add("B");
        list.add("A");
        list.removeLastOccurrence("A");
        System.out.println("remove lst occurance A: " + list);
    }
}
