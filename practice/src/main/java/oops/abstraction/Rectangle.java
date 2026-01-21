package oops.abstraction;

public class Rectangle implements shape{
    public double width;
    public double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width*height;
    }
}
