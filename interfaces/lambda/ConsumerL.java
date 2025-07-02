
import java.util.function.Consumer;

public class ConsumerL {
    public static void main(String[] args) {
        Consumer<String> printConsumer = s -> System.out.println();
        printConsumer.accept("Hello, World!");
    }
}
