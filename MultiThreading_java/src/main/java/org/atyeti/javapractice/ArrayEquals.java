package org.atyeti.javapractice;

import java.util.Arrays;

public class ArrayEquals {
    public static void main(String[] args) {
        int[] a={1,2,3};
        int [] b={3,2,1};
        boolean res=areEquals(a,b);
        System.out.println(res);
    }

    private static boolean areEquals(int[] a, int[] b) {
        if (a.length != b.length) return false;
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a,b);
    }
}
