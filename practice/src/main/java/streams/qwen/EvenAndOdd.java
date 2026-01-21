package streams.qwen;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EvenAndOdd {
    public static void main(String[] args) {
        List<Integer> li= Arrays.asList(1, 2, 3, 4);
        Map<Boolean, List<Integer>> mp=li.stream().collect(
                Collectors.partitioningBy(n->n%2==0));
        System.out.println(mp);
    }
}
