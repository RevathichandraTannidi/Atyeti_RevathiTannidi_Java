package org.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsExample1 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Integer> result = list.stream()
                .filter(n -> n % 2 == 0)   // step 1: filter even numbers
                .map(n -> n * 2)           // step 2: double them
                .collect(Collectors.toList()); // step 3: collect result

        System.out.println(result);
    }
}
