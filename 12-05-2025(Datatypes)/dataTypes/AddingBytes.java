package dataTypes;

import java.util.Scanner;

//Problem:
//Write a method that accepts two byte values and returns their sum as a byte,
// preserving overflow behavior (simulate how hardware would do it).
// in java,Byte+Byte=int - Hint
public class AddingBytes {

    public static byte addBytes(byte a, byte b)
    {
        byte res= (byte) (a+b);

        return res;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a:");
        byte a=sc.nextByte();
        System.out.println("enter b:");
        byte b=sc.nextByte();
        System.out.println(" adding the bytes :"+addBytes(a,b));

    }
}
