package org.atyeti.javapractice;

import java.util.ArrayList;
import java.util.List;

public class Duplicates_in_array {
    public static void main(String[] args) {
        int[] nums={1, 2, 3, 1, 3, 6};
        List<Integer> res=new ArrayList<>();
        for(int i=0;i< nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++){
            if(nums[i]==nums[j]) {
           res.add(nums[i]);
            }
            }
        }
        System.out.println(res);
    }
}
