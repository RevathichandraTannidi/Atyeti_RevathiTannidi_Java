package org.atyeti.javapractice;

public class MissingNumberBoolean {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 5};

        int n = nums.length + 1; // numbers should be from 1 to n

        for (int i = 1; i <= n; i++) {
            boolean found = false;

            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == i) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println(i);
                break;
            }
        }
    }
}