package operators;

import java.util.Scanner;

public class LogicalOperator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = scanner.nextInt();

        boolean isValid = (num > 0) && (num % 2 == 0) && (num < 100);
        System.out.println("Is the number valid (positive, even, less than 100)? " + isValid);
    }
}
