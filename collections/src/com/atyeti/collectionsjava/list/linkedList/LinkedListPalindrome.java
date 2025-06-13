package com.atyeti.collections.list.linkedList;

import java.util.LinkedList;

public class LinkedListPalindrome {

    public static boolean isPalindrome(LinkedList<Character> list) {
        while (list.size() > 1) {
            char first = list.pollFirst();  // Remove and get first element
            char last = list.pollLast();    // Remove and get last element

            if (first != last) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LinkedList<Character> list1 = new LinkedList<>();
        for (char c : "racecar".toCharArray()) {
            list1.add(c);
        }

        LinkedList<Character> list2 = new LinkedList<>();
        for (char c : "hello".toCharArray()) {
            list2.add(c);
        }

        System.out.println("Is 'racecar' a palindrome? " + isPalindrome(new LinkedList<>(list1)));
        System.out.println("Is 'hello' a palindrome? " + isPalindrome(new LinkedList<>(list2)));
    }
}

