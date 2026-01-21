package oops.oopsGFG;

abstract class Shape {
     public abstract  double calculateArea() ;
     public abstract  void display();
}

class Circle extends Shape{
public double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
     return Math.PI * radius * radius;
    }

    @Override
    public void display() {
        System.out.println("the area of circle :" + calculateArea());
    }

}
class Rectangle extends Shape{
  private  double length,width;
    public Rectangle(double length,double width)
    {
        this.length=length;
        this.width=width;
    }
    @Override
    public double calculateArea() {
        return length*width;
    }

    @Override
    public void display() {
        System.out.println("the area od the Rectangle :" +calculateArea());
    }
}
class Triangle extends Shape
{
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5*base*height;
    }

    @Override
    public void display() {
        System.out.println("the area of triangle :"+calculateArea());

    }

    public static void main(String[] args) {
        Shape s=new Rectangle(2.0,4.0);
        Circle circle = new Circle(5.0);

        Triangle triangle = new Triangle(3.0, 8.0);
        s.display();
        circle.display();
        triangle.display();
    }
}

