package oops.methodoverloadingoverriding;

public class Cal {
   public int multiply(int a, int b)
   {

       return a*b;
   }
    public double multiply(double a, double b)
    {
        return  a*b;
    }
  public  int multiply(int a, int b, int c)
  {
      return a*b*c;
  }

    public static void main(String[] args) {
        Cal c=new Cal();
        System.out.println(c.multiply(2,3));
        System.out.println(c.multiply(2.0,6.0));
        System.out.println(c.multiply(4,7,3));

           }
}
