package oops.abstraction;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<shape> li=new ArrayList<>();
        li.add(new Circle(23));
        li.add(new Rectangle(3,5));
        for(shape shapes: li)

        {
            System.out.println("area : "+ shapes.area());
        }
    }
}
