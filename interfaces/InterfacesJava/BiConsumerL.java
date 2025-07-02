

import java.util.function.BiConsumer;

public class BiConsumerL {
    public static void main(String[] args) {
        BiConsumer<String, Integer> printBiConsumer = (s, i) -> System.out.println(s + ": " + i);
        printBiConsumer.accept("Age", 30);
    }
}
