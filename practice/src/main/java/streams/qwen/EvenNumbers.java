package streams.qwen;

import java.util.Arrays;
import java.util.List;

public class EvenNumbers {
    public static void main(String[] args) {
        List<Integer> li= Arrays.asList(1,2,3,4,5,6,7,3);
        List<Integer> res=li.stream().filter(m->m%2==0).toList();
        System.out.println(res);

    }
}
