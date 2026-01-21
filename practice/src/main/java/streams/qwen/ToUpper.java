package streams.qwen;

import java.util.Arrays;
import java.util.List;

public class ToUpper {
    public static void main(String[] args) {
        List<String> li = Arrays.asList("Java","mAin","sindu");
        List<String> res=li.stream().map(String::toUpperCase).toList();
        System.out.println(res);
    }
}
