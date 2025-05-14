package dataTypes;

import java.util.Scanner;

public class InchTometer {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double onemeter =0.0254;
        System.out.print("enter the inch value:");
        double inch=sc.nextDouble();
        double meters=inch* onemeter;
        System.out.println("inch to meter :"+meters);

    }
}
