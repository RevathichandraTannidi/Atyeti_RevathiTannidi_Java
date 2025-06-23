package com.atyeti.collections.list.arrayList;

import java.util.ArrayList;
import java.util.List;

public class EvenArray {
    private final List<Integer> list = new ArrayList<>();

    public void add(Integer num) {
        if (isEven(num)) {
            list.add(num);
        } else {
            throw new IllegalArgumentException("Only even numbers are allowed");
        }
    }

    public void addAll(List<Integer> nums) {
        for (int num : nums) {
            if (!isEven(num)) {
                throw new IllegalArgumentException("Only even numbers are allowed");
            }
        }
        list.addAll(nums);
    }

    public List<Integer> getList() {
        return new ArrayList<>(list); // returns copy
    }

    private boolean isEven(Integer num) {
        return num != null && num % 2 == 0;
    }

    public static void main(String[] args) {
EvenArray evenArray=new EvenArray();
        evenArray.add(2);
evenArray.addAll(List.of(4, 6, 8));
 System.out.println(evenArray.getList());

    }
}
