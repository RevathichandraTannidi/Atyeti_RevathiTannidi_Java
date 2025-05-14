package dataTypes;
//Write code that compares different values of wrapper types (e.g., Integer, Double, Boolean)
// using == and .equals(), and explain the output.
public class Wrapper_classes {
    public static void main(String[] args) {
        Integer a = 127;
        Integer b = 127;
        System.out.println(a == b);
        System.out.println(a.equals(b));// true or false?

        Integer c = 128;
        Integer d = 128;
        System.out.println(c == d);// //
        System.out.println(c.equals(d)); // it checks the value


    }
}
