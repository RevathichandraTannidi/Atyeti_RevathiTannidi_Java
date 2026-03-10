package org.atyeti.java.practice;

import java.util.Arrays;

public class Practicejava {
    public void  moveZerostoEnd(int[] nums)
    {
        int  j=0;
        for(int i=0;i< nums.length;i++) {
            if(nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }

    public static void main(String[] args) {
Practicejava p=new Practicejava();
      int [] arr={2,3,0,8,6,9,5,0,5,9,5,0,0,6,5,0};

  //Arrays.toString(arr);
        p.moveZerostoEnd(arr);
        System.out.println("Output: " + Arrays.toString(arr));


    }
}
