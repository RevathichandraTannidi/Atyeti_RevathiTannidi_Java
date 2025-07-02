package lambda;

import java.util.*;
import java.util.stream.Collectors;

public class Sum {
    public static void main(String[] args) {
        List<Integer> li=new ArrayList<>(Arrays.asList(23, 3, 5, 7, 2, 6));
        li.add(3);

        System.out.println( li.stream().map(e-> e+e).peek(e-> System.out.println(e)).collect(Collectors.toList()));

        int sum = li.stream().collect(Collectors.summingInt(Integer::intValue));
        System.out.println("Sum of all elements: " + sum);


    }
}
