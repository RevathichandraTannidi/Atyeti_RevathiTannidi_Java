package streams;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDuplicares {
    public static void main(String[] args) {
        List<String> names = List.of("Java", "Spring", "Java", "Docker", "Spring");
        Set<String> Dup=names.stream().filter(n-> Collections.frequency(names,n)>1).collect(Collectors.toSet());;
        System.out.println(Dup);

List<String> li=names.stream().distinct().collect(Collectors.toUnmodifiableList());
        System.out.println(li);
       // Set<String> seen = new HashSet<>();
//        Set<String> duplicates =
//                names.stream()
//                        .filter(n -> !seen.add(n))
//                        .collect(Collectors.toSet());
//        System.out.println(duplicates);

    }
}
