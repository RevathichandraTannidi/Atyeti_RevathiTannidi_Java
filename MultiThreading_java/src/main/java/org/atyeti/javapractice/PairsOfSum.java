package org.atyeti.javapractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairsOfSum {
    public static void main(String[] args) {
      int[] nums ={1,5,7,-1,5 };
      int target=6;
      List<List<Integer>> res=new ArrayList<>();

      for(int i=0;i<nums.length;i++)
      {
          for(int j=i+1; j< nums.length;j++)
          {
              if(nums[i]+nums[j]==target)
              {
               res.add(Arrays.asList(nums[i],nums[j]));
              }
          }
      }
        System.out.println(res);
    }
}
