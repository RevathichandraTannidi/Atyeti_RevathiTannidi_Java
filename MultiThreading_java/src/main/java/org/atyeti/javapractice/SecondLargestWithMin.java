package org.atyeti.javapractice;

public class SecondLargestWithMin {
    public static void main(String[] args) {
        int[] arr = {10, 45, 23, 67, 34, 67};

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            }
            else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("No second largest element");
        } else {
            System.out.println("Second Largest: " + secondLargest);
        }
    }
}
