package org.atyeti.java.practice;

public class Fibonacci {
    public static void main(String[] args) {
        int a=5;
for(int i=0;i<a;i++) {
    System.out.print( fibonnaci(i)+" ");
}   }
    public static long fibonnaci(int n)
    {
        if(n<0) throw new IllegalArgumentException("n must be positive number");
        if (n==0) return 0;
        if(n==1) return 1;
        long prev=0,curr=1;
        while(n>1)
        {
long next=prev+curr;
prev=curr;
curr=next;
n--;
        }
        return  curr;
    }
}
