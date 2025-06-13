package com.atyeti.collections.list.arrayList;

import java.util.ArrayList;
import java.util.List;

class CustomList<E> extends ArrayList<E> {
    public void dropRange(int from, int to) {
        super.removeRange(from, to); // its like slice
    }
}

public class TestRemoveRange {
    public static void main(String[] args) {
        CustomList<String> cl = new CustomList<>();
        cl.addAll(List.of("A", "B", "C", "D", "E", "F"));
        cl.dropRange(1, 4);
        System.out.println(cl);
    }
}
