package Exception;

public class Main {
    public static void main(String[] args) {
        try
        {
            int a[]=new int [5];
            a[5]=30/0;
        }
        catch(ArithmeticException e)
        {
            System.out.println("arthemetic");
        }
        catch(ArrayIndexOutOfBoundsException ex)
        {
            System.out.println("Array index out of bond" +ex);
        }

        System.out.println( Main.example3());
    }
    public static int example3() {
        int x = 10;
        try {
            return x; // value 10 is "saved" to return
        } finally {
           throw new RuntimeException();// too late! return value is already decided
        }
    }
}
