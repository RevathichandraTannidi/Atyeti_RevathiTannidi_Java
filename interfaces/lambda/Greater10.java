
import java.util.function.Predicate;

public class Greater10 {
    public static void main(String[] args) {
        Predicate<Integer> i=s->s>10;
        System.out.println(i.test(34));
    }
}
