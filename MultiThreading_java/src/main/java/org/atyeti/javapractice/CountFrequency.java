package org.atyeti.javapractice;

import java.util.Arrays;

public class CountFrequency {
    public static void main(String[] args) {
        int [] num={2,2,3,3,4,5,6,4,5,1,3,1,1,5,6,5,1,1,1,2,6};
        Arrays.sort(num);
        int count=1;

        for(int i=1;i< num.length;i++)
        {
            if(num[i]==num[i-1])
            {
                count++;
            }
            else {
                System.out.println(num[i-1]+"-"+ count);
                count=1;
            }
        }
        System.out.println(num[num.length-1]+ " -> "+ count);
    }
}
