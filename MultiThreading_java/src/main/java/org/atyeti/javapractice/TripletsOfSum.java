package org.atyeti.javapractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletsOfSum {
    public static void main(String[] args) {
        int[] nums = {1, 2, -2, 0, -1, 1};
        int target = 0;

        List<List<Integer>> res=new ArrayList<>();

        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1; j< nums.length;j++)
            {
                for(int k=j+1; k< nums.length;k++){
                if(nums[i]+nums[j]+nums[k]==target)
                {
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                }
                }
            }
        }
        System.out.println(res);
    }

}
