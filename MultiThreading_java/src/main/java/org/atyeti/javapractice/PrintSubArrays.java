package org.atyeti.javapractice;

public class PrintSubArrays {
    public static void main(String[] args) {
        int[] nums={1,2,3};

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {

                System.out.print("[");
                for (int k = i; k <= j; k++) {
                    System.out.print(nums[k] + (k < j ? ", " : ""));
                }
                System.out.print("], ");
            }
        }

    }
}
