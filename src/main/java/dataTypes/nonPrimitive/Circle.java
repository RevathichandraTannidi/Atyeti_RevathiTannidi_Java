package dataTypes.nonPrimitive;

public class Circle implements  Drawable{
    @Override
    public void draw() {
        System.out.println("circle will be drawn by radius and diameter");
    }

}
class Main extends Circle
{
    public static void main(String[] args) {
        Circle c=new Circle();
        c.draw();
    }
}