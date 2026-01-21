package streams.qwen;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LongestString {
    public static void main(String[] args) {
        List<String> li= Arrays.asList("hi","hello","hai","revathi");
        String res=li.stream().max(Comparator.comparing(String::length)).orElse(null);
        System.out.println(res);

    }
}
