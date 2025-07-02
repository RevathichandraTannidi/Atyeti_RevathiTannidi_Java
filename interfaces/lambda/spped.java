import java.util.function.Consumer;
import java.util.function.Function;

public class spped {
    public static void main(String[] args) {

        speed s2=(i)-> System.out.println(i);
        s2.speeeed(89);
        speed s=System.out::println;

        s.speeeed(98);
        Consumer<Integer> s1 = (x) -> System.out.println("Speed: " + x);

        s1.accept(98);

    }

    interface speed
    {
        void speeeed(int x);
    }
}
