package streams.qwen;

import java.util.Arrays;
import java.util.*;
import java.util.stream.Collectors;

public class RemoveDupANdSort {
    public static void main(String[] args) {
        List<Integer> li= Arrays.asList(5, 2, 5, 1, 2);
    //    Set unique1=new HashSet();
     //   List<Integer> res=li.stream().filter(n->unique1.add(n)).sorted().toList();
        List<Integer> res=li.stream().distinct().sorted().collect(Collectors.toList());

        System.out.println(res);
    }
}
