package operators;

import java.util.Scanner;

public class UnaryOperator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = scanner.nextInt();

        System.out.println("Original value: " + num);
        System.out.println("Pre-increment: " + (++num));
        System.out.println("Post-increment: " + (num++));
        System.out.println("Value after post-increment: " + num);
        System.out.println("Pre-decrement: " + (--num));
        System.out.println("Post-decrement: " + (num--));
        System.out.println("Value after post-decrement: " + num);
    }
}
