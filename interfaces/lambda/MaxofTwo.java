
import java.util.function.BiFunction;

public class MaxofTwo {
    public static void main(String[] args) {
        BiFunction<Integer,Integer,Integer> max=(a,b)->Math.max(a,b);
        System.out.println(max.apply(5,6));
    }
}
