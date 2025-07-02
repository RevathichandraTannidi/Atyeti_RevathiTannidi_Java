

import java.util.Arrays;
import java.util.List;

public class FindFirst {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Annie", "Bhanu", "Jai", "Jashwant");
        String firstMatch = names.stream()
                .filter(s -> s.startsWith("J"))
                .findFirst()
                .orElse("No match");
        System.out.println(firstMatch);
    }
}
