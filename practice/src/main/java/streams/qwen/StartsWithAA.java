package streams.qwen;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StartsWithAA {
    public static void main(String[] args) {
        List<String> li= Arrays.asList("alice", "Bob", "Amy");
        List<String> res=li.stream().map(String::toUpperCase).filter(n->n.startsWith("A")).collect(Collectors.toList());
        System.out.println(res);
    }
}
