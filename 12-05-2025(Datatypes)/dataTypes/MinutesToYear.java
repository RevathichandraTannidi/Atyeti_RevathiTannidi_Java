package dataTypes;

import java.util.Scanner;

public class MinutesToYear {
    public static void main(String[] args) {
        double minutesToYear=60*24*365;
        Scanner sc=new Scanner(System.in);
        double min=sc.nextDouble();
        Long years = (long) (min / minutesToYear);
        int days = (int) (min / 60 / 24) % 365;

        System.out.println((int) min + " minutes is approximately " + years + " years and " + days + " days");

    }
}
