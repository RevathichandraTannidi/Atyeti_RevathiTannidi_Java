package conditionalStatements;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Item {
    String name;
    int quantity;
    double price;

    Item(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}

public class Online_shopping_cart {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Item> cart = new ArrayList<>();

        System.out.print("Enter the number of items: ");
        int numberOfItems = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfItems; i++) {
            System.out.print("Enter item name: ");
            String name = scanner.nextLine();
            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            System.out.print("Enter price: ");
            double price = scanner.nextDouble();
            scanner.nextLine();

            cart.add(new Item(name, quantity, price));
        }


        double totalPrice = calculateTotalPrice(cart);
        double finalPrice = applyDiscount(totalPrice);

        generateBill(cart, totalPrice, finalPrice);

        scanner.close();
    }

    public static double calculateTotalPrice(List<Item> cart) {
        double totalPrice = 0;
        for (Item item : cart) {
            totalPrice += item.quantity * item.price;
        }
        return totalPrice;
    }

    public static double applyDiscount(double totalPrice) {
        double discount;
        if (totalPrice > 5000) {
            discount = 0.15;
        } else if (totalPrice > 2000) {
            discount = 0.10;
        } else {
            discount = 0.0;
        }
        return totalPrice * (1 - discount);
    }

    public static void generateBill(List<Item> cart, double totalPrice, double finalPrice) {
        System.out.println("Shopping Cart Bill");
        for (Item item : cart) {
            System.out.printf("%s (x%d): ₹%.2f\n", item.name, item.quantity, item.quantity * item.price);
        }
        System.out.println("------------------");
        System.out.printf("Total Price: ₹%.2f\n", totalPrice);
        System.out.printf("Final Price after discount: ₹%.2f\n", finalPrice);
    }
}

