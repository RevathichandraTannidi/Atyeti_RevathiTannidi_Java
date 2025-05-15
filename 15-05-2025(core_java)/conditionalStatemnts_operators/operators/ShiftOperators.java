package operators;
import java.util.Scanner;

public class ShiftOperators {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = scanner.nextInt();

        System.out.println("Original: " + Integer.toBinaryString(num));
        System.out.println("Left shift (<<): " + Integer.toBinaryString(num << 1));
        System.out.println("Right shift (>>): " + Integer.toBinaryString(num >> 1));
        System.out.println("Unsigned right shift (>>>): " + Integer.toBinaryString(num >>> 1));
    }
}

