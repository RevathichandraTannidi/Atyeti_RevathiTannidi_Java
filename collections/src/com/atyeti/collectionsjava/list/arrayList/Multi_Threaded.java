package com.atyeti.collections.list.arrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Multi_Threaded {
    public static void main(String[] args) {
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < 100; i++) {
            new Thread(() -> list.add((int) (Math.random() * 100))).start();
        }
        System.out.println(list);

        List<String> colist = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> colist.add(String.valueOf((int) (Math.random() * 100)))).start();
        }
        System.out.println(colist);
    }
}

// to make array list in thread safe