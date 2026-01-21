package scrum.arrays;

import java.util.Arrays;

public class CopyArray {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4}; //1234 -> 1123 ->1212
        System.arraycopy(a, 0, a, 2, 2);
        System.out.println(Arrays.toString(a));

    }
}
