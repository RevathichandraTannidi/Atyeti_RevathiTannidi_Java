package polymorphism.onlineShoppingDiscount;

abstract class Customer {
    protected String name;
    protected double purchaseAmount;

    public Customer(String name, double purchaseAmount) {
        this.name = name;
        this.purchaseAmount = purchaseAmount;
    }

    public abstract double calculateDiscount();


    public void displayDetails() {
        System.out.println("Customer Name: " + name);
        System.out.println("Purchase Amount: $" + purchaseAmount);
        System.out.println("Discount: $" + calculateDiscount());
        System.out.println("Amount to Pay: $" + (purchaseAmount - calculateDiscount()));

    }
}
