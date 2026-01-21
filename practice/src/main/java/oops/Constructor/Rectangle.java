package oops.Constructor;

import oops.encapuslation.Student;

public class Rectangle {
    private int width;
    private int height;

    public Rectangle() {
    this(1,1);
    }

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }
public int area()
{
    return width*height;
}

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }

    public static void main(String[] args) {
        Rectangle r1=new Rectangle();
        System.out.println(r1);
        Rectangle r= new Rectangle(2,3);
        System.out.println(r);
        System.out.println(r.area());
    }

}
