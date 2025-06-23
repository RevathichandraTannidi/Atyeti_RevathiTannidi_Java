package com.atyeti.collections.list.arrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SafeRemoval {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("a", "b", "remove", "c"));
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().equals("remove")) {
                it.remove();
            }
        }
        System.out.println("After removal: " + list);

    }
}
