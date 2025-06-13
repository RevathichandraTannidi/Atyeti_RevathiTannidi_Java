package com.atyeti.collections.list.linkedList;

import java.util.LinkedList;

public class MiddleOne {
    public static void main(String[] args) {
        LinkedList<Integer> li=new LinkedList<>();
        li.add(1);

        li.add(3);
        li.add(8);
        li.add(6);
        li.add(0);

        System.out.println(li.size());
        System.out.println(li.get((li.size())/2));
    }
}
