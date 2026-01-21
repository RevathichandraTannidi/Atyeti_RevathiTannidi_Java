package streams.qwen;

import java.util.Arrays;
import java.util.List;

public class CountString {
    public static void main(String[] args) {
        List<String> li = Arrays.asList("Java","mAin","sindu","ramu","seetha");
        long count=li.stream().filter(n->n.length()>4).count();
        System.out.println(count);

    }
}
