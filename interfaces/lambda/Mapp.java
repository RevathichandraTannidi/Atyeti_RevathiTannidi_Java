

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Mapp {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("chandra", "REVAThi", "kumar");
        List<String> upperCaseNames = names.stream()
                .map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(upperCaseNames);
    }
}
