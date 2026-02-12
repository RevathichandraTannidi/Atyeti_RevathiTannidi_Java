package org.atyeti.javapractice;

import java.util.HashSet;
import java.util.Set;

public class UniqueCount {
    public static void main(String[] args) {

        String str = "programming";

        // Convert string to char array
        char[] chars = str.toCharArray();

        // Set to store unique characters
        Set<Character> set = new HashSet<>();

        for (char c : chars) {
            set.add(c);
        }

        // Count occurrences
        for (char c : set) {
            int count = 0;
            for (char ch : chars) {
                if (c == ch) {
                    count++;
                }
            }
            System.out.println(c + " : " + count);
        }
    }
}
