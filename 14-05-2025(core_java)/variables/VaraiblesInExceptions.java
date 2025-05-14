public class VaraiblesInExceptions {
    public static void main(String[] args) {
        try
        {
            int x=10;
            System.out.println(x);
        } catch (Exception e) {
            System.out.println("x is not working in try block");
        }
        finally {
            System.out.println("finally try to print x in exception handling");
        }
       // System.out.println(x);
        // try to run the x outside the exception it throws the error .
    }
}
