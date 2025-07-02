

import java.util.function.BiFunction;

public class BiFunctionL {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> addFunction = (a, b) -> a + b;
        int result = addFunction.apply(5, 3);
        System.out.println(result);
    }
}
