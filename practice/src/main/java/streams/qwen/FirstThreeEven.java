package streams.qwen;

import java.util.Arrays;
import java.util.List;

public class FirstThreeEven {
    public static void main(String[] args) {
        List<Integer> li= Arrays.asList(1,2,3,4,5,6,7,8,9,11,12,1,3,14,53);
        List<Integer> str=li.stream().filter(n->n%2==0).limit(3).toList();
        System.out.println(str);
    }
}
