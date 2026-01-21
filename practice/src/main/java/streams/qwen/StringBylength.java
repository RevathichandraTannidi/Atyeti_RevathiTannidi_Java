package streams.qwen;

import java.util.*;
import java.util.stream.Collectors;

//{1=["a"], 2=["bb","dd"], 3=["ccc"]}
public class StringBylength {
    public static void main(String[] args) {
     List<String> li=Arrays.asList("a", "bb", "ccc", "dd");
     Map<Integer,List<String>> map=li.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(map);


    }
}
