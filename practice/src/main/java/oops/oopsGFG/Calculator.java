package oops.oopsGFG;

public class Calculator {
   public int calculateSum(int number1, int number2)
   {
       return number1+number2;
   }
 public int   calculateDifference(int number1, int number2)
 {
     return  number1-number2;
 }

    public static void main(String[] args) {
        Calculator c=new Calculator();
        System.out.println(  c.calculateDifference(55,33));
        System.out.println(    c.calculateSum(33,22));

    }
}
