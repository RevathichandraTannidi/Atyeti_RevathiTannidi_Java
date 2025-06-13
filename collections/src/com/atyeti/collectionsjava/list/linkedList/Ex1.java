package com.atyeti.collections.list.linkedList;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Ex1 {
    public static void main(String[] args) {
        LinkedList<String> cities = new LinkedList<>(List.of("Delhi","Agra","Mysore","Chennai","Pune"));
        ListIterator<String> it = cities.listIterator();


        while (it.hasNext()) {
            System.out.println(it.next());
        }

        while (it.hasPrevious()) {
            System.out.println(it.previous());
        }

    }

}
