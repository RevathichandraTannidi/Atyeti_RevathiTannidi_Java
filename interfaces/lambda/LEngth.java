

import java.util.function.Function;
import java.util.function.Predicate;

public class LEngth {
    public static void main(String[] args) {
        //Create a lambda expression that takes a string and returns its length.
        Function<String,Integer> s=s2->s2.length();
        System.out.println(s.apply("hi fd cn"));
    }
}
