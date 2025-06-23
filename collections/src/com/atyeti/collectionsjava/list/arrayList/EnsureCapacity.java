package com.atyeti.collections.list.arrayList;

import java.util.ArrayList;

public class EnsureCapacity {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("Initial capacity: " + getArrayListCapacity(list));

        list.ensureCapacity(100);
        System.out.println("Capacity after ensureCapacity: " + getArrayListCapacity(list));
    }

    private static int getArrayListCapacity(ArrayList<?> list) {
        try {
            java.lang.reflect.Field field = ArrayList.class.getDeclaredField("elementData");
            field.setAccessible(true);
            Object[] elementData = (Object[]) field.get(list);
            return elementData.length;
        } catch (Exception e) {
            e.printStackTrace();
         return -1;
        }
    }
}
