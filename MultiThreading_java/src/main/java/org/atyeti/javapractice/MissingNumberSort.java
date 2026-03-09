package org.atyeti.javapractice;

import java.util.Arrays;

public class MissingNumberSort {
    public static int findMissing(int[] nums) {
        Arrays.sort(nums); // Step 1: sort ascending

        // Step 2 & 3: check expected value at each index
        for (int i = 0; i < nums.length; i++) {
            int expected = i + 1;   // because values should be 1..N
            if (nums[i] != expected) {
                return expected;    // first mismatch means expected is missing
            }
        }

        // Step 4: if no mismatch, missing number is the last one N
        return nums.length + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 5};
        System.out.println(findMissing(nums)); // 3
    }
}
