package com.atyeti.collections.list.arrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnknownMethods {

    public static void main(String[] args) {
        List<String> team = new ArrayList<>(List.of("A", "B", "C", "D"));
        Collections.rotate(team, 2);
        System.out.println(team);


        List<Integer> cards = new ArrayList<>(List.of(1,2,3,4,5));
        Collections.shuffle(cards);


        List<String> items = new ArrayList<>(List.of("first", "middle", "last"));
        Collections.swap(items, 0, 2);


        List<Integer> nums = List.of(1, 2, 1, 3, 1);
        int freq = Collections.frequency(nums, 1);
        System.out.println(freq);



        List<Integer> arr = new ArrayList<>(List.of(0,0,0,0));
        Collections.fill(arr, 5);
        System.out.println(arr);


        List<String> ones = Collections.nCopies(5, "one");
        System.out.println(ones);



    }
}
