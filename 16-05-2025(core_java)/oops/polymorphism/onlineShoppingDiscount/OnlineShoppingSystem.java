package polymorphism.onlineShoppingDiscount;

public class OnlineShoppingSystem {
    public static void main(String[] args) {
        // Creating an array of Customer references
        Customer[] customers = new Customer[3];
        customers[0] = new RegularCustomer("sowmya", 200.0);
        customers[1] = new PremiumCustomer("vamsi", 500.0);
        customers[2] = new EliteCustomer("revathi chandra", 1000.0);


        for (Customer customer : customers) {
            customer.displayDetails();
        }
    }
}

