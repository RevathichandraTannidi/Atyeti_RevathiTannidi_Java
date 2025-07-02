package Interfacesj;

class PayPalPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println( amount + " via PayPal");
    }
}
