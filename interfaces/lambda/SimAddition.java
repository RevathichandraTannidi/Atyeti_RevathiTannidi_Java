package lambda;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class SimAddition {
    public static void main(String[] args) {
        BiFunction<Integer,Integer,Integer > s=(a,b)->a+b;
        System.out.println(s.apply(2,3));
        BinaryOperator<Integer> e=( a,b) -> a*b;
        System.out.println(e.apply(5,4));


    }
}
