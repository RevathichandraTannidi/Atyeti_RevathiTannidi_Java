

import java.util.function.Function;

public class FunctionL {
    public static void main(String[] args) {
        Function<String, Integer> lengthFunction = s -> s.length();
        System.out.println(lengthFunction.apply("Hello"));
    }
}
