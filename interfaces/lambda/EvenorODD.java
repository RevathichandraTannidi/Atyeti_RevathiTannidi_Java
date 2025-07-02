

import java.util.function.Predicate;

public class EvenorODD {
    public static void main(String[] args) {
        Predicate<Integer> s=s1->s1%2==0;
        System.out.println(s.test(223));

    }
}
