package Mapss;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class example3 {
    public static void main(String[] args) {
        Map<Integer[], String> map = new HashMap<>();

        Integer[] k1 = {1,2,3};
        map.put(k1, "DATA");

        Integer[] k2 = {1,2,3};
      //  map.put(k2,"DATA");

        System.out.println(map.get(k2));

        TreeMap<Integer,String> mp=new TreeMap<>();
        mp.put(1,"data");

        System.out.println(mp);

    }
}
