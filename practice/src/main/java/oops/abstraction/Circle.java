package oops.abstraction;

public class Circle implements shape{
    public double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return radius* radius;
    }
}
