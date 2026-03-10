package org.atyeti.java.practice;

import java.util.Arrays;

public class DuplicateElements {
    public static void main(String[] args) {
        int[] a ={1,2,3,4,2,1,4,5,3,5,2,1,3};
        int count=0;
        boolean[] isDuplicate=new boolean[a.length];
        for(int i=0;i<a.length;i++)
        {
            if (!isDuplicate[i]) {
              count++;
            }
         for(int j=i +1;j<a.length;j++)
         {
             if(a[i]==a[j])
             {


        isDuplicate[j]=true;

             }
         }
        }
        int[] result = new int[count];
        int index = 0;
        for (int i = 0; i < a.length; i++) {
            if (!isDuplicate[i]) {
                result[index++] = a[i];
            }
        }

        System.out.println("Original: " + Arrays.toString(a));
        System.out.println("Unique:   " + Arrays.toString(result));
    }
}
