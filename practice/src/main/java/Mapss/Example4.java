package Mapss;

import java.util.*;

public class Example4 {
    public static void main(String[] args) {
        Map<List<Integer>, String> map = new HashMap<>();

        List<Integer> key = new ArrayList<>();
        key.add(2);
        key.add(3);
        map.put(key, "X");
        List<Integer> key2=new ArrayList<>();
        key2.add(3);
        key2.add(4);
        map.put(key2,"y");
key.add(5);
     //   key.add(4);

        System.out.println(map);

        Map<String, String> map1 = new IdentityHashMap<>();

        map1.put("A", "1");
        map1.put("A", "2");

        System.out.println(map1.size());


    }
}
