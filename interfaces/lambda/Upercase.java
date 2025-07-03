

import java.util.function.Consumer;

public class Upercase {
    public static void main(String[] args) {
        Consumer<String > c=s-> System.out.println(s.toUpperCase());
        c.accept("revsgik");

    }
}
