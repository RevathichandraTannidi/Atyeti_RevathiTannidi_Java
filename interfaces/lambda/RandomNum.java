
import java.util.function.Supplier;

public class RandomNum {
    public static void main(String[] args) {
        Supplier<Integer> i=()->
             (int)( Math.random()*100)+1;

        System.out.println(i.get());
    }
}
