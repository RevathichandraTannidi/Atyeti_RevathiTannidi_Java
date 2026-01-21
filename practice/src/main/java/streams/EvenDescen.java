package streams;

import java.util.*;
import java.util.stream.Collectors;

public class EvenDescen {
    public static void main(String[] args) {
        List<Integer> li = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> res=li.stream().filter(n->(n%2==0)).map(n->n*n).sorted(Comparator.reverseOrder()).collect(Collectors.toUnmodifiableList());
     int  ress= li.stream().mapToInt(Integer::intValue).sum();
        System.out.println(ress);
        System.out.println(res);



        List<String> list = List.of("Java", "Spring", "Java", "Docker");

        Map<String, Long> frequency =
                list.stream()
                        .collect(Collectors.groupingBy(
                                e -> e,
                                Collectors.counting()
                        ));

        System.out.println(frequency);

    }
}
