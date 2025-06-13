package com.atyeti.collections.list.linkedList;

import java.util.LinkedList;
import java.util.ListIterator;

public class Reverse_linkedlist {
    public static void main(String[] args) {
        LinkedList<String> li=new LinkedList<>();
        li.add("one");
        li.add("Two");
        li.add("three");
        li.add("four");
        ListIterator<String> litr1 = li.listIterator();
        ListIterator<String> litr = li.listIterator(li.size());

        System.out.println("forward");
        while(litr1.hasNext())
        {
            System.out.println(litr1.next());
        }

        System.out.println("backward");
        while(litr.hasPrevious())
        {
            System.out.println( litr.previous());

        }


    }
}
