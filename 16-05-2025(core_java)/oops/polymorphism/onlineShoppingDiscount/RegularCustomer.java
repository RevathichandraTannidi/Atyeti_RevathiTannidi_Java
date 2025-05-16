package polymorphism.onlineShoppingDiscount;

class RegularCustomer extends Customer {
    public RegularCustomer(String name, double purchaseAmount) {
        super(name, purchaseAmount);
    }

    @Override
    public double calculateDiscount() {
        return purchaseAmount * 0.05; // 5% discount
    }
}

class PremiumCustomer extends Customer {
    public PremiumCustomer(String name, double purchaseAmount) {
        super(name, purchaseAmount);
    }

    @Override
    public double calculateDiscount() {
        return purchaseAmount * 0.10; // 10% discount
    }
}

class EliteCustomer extends Customer {
    public EliteCustomer(String name, double purchaseAmount) {
        super(name, purchaseAmount);
    }

    @Override
    public double calculateDiscount() {
        return purchaseAmount * 0.15; // 15% discount
    }
}
