package operators;

import java.util.Scanner;

public class AssignmentOperators {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = scanner.nextInt();

        num += 5;
        System.out.println("After += 5: " + num);
        num -= 3;
        System.out.println("After -= 3: " + num);
        num *= 2;
        System.out.println("After *= 2: " + num);
        num /= 4;
        System.out.println("After /= 4: " + num);
        num %= 3;
        System.out.println("After %= 3: " + num);
    }
}
