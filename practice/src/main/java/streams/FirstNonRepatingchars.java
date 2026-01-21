package streams;

import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class FirstNonRepatingchars {
    public static void main(String[] args) {
        String input = "aabbcddeef";
        Character result =
                input.chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.groupingBy(
                                c -> c,
                                LinkedHashMap::new,
                                Collectors.counting()
                        ))
                        .entrySet().stream()
                        .filter(e -> e.getValue() == 1)
                        .map(Map.Entry::getKey)
                        .findFirst()
                        .orElse(null);
        System.out.println(result);
      String li =input.chars()
              .distinct()
              .mapToObj(c -> String.valueOf((char) c))
              .collect(Collectors.joining());
        System.out.println("unique characters in a string "+li);


    }
}
