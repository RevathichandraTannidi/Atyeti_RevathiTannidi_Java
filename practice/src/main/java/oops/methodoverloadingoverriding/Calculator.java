package oops.methodoverloadingoverriding;

public class Calculator {
    public int add(int a,int b)
    {
        return a+b;
    }

    public double add(double a,double b)
    {
        return a+b;
    }

}
class mi{
    public static void main(String[] args) {
        Calculator cl=new Calculator();
        System.out.println(  cl.add(2,3));
        System.out.println(  cl.add(2.0,4.0));
    }
}
