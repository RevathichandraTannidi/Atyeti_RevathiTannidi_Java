package org.atyeti.javapractice;

import java.util.Arrays;

public class SecondLargest {

    public static void main(String[] args) {
        int[] num={1,7,9,3,5};
        Arrays.sort(num);
        System.out.println("by using the sorting technique for the second largest number "+ num[num.length-2]);

// Approach -2
        int n = num.length;

        int largest = num[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            if (num[i] != largest) {
                System.out.println("Second largest: " + num[i]);
                break;
            }
        }
        }
}
