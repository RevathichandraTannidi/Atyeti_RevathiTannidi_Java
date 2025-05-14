package dataTypes;

import java.util.Scanner;

public class DataTypeRangeChecker {

    public static void checkDataType(long number) {
        if (number >= Byte.MIN_VALUE && number <= Byte.MAX_VALUE) {
            System.out.println(number + " can be stored in a byte.");
        } else if (number >= Short.MIN_VALUE && number <= Short.MAX_VALUE) {
            System.out.println(number + " can be stored in a short.");
        } else if (number >= Integer.MIN_VALUE && number <= Integer.MAX_VALUE) {
            System.out.println(number + " can be stored in an int.");
        } else if (number >= Long.MIN_VALUE && number <= Long.MAX_VALUE) {
            System.out.println(number + " can be stored in a long.");
        } else {
            System.out.println(number + " is out of range for all primitive data types.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        long number = scanner.nextLong();
        checkDataType(number);
    }
}

