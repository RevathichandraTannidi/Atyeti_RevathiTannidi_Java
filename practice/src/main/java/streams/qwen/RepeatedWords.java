package streams.qwen;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RepeatedWords {
    public static void main(String[] args) {
        List<String> li= Arrays.asList("apple","Apple","Banana");
        Map<String,Long> res=li.stream().map(s->s.toLowerCase()).
                collect(Collectors.groupingBy(s->s,Collectors.counting()));
        System.out.println(res);

//        Map<String, Long> res = li.stream()
//                .collect(Collectors.groupingBy(
//                        s -> s.toLowerCase(),          // classifier: lowercase
//                        Collectors.counting()          // downstream: count
//                ));
//

    }
}
