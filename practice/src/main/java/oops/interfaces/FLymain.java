package oops.interfaces;

public class FLymain {
    public static void
    letItFly(Flyable f) {
        f.fly();
    }

    public static void main(String[] args) {

        Flyable bird = new Bird();
        Flyable airplane = new Airplane();

        // Call letItFly with both objects
        letItFly(bird);
        letItFly(airplane);

        // Bonus: anonymous class & lambda-like (since Flyable is a functional interface)
        Flyable drone = new Flyable() {
            @Override
            public void fly() {
                System.out.println("The drone buzzes and ascends vertically.");
            }
        };
        letItFly(drone);
    }

}

