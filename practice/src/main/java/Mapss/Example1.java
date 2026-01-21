package Mapss;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Example1 {

    public static void main(String[] args) {

Map<String,Integer> mp=new LinkedHashMap<>();
mp.put("a",23);
mp.put("b",45);
mp.put("c",13);
mp.put("y",34);
mp.put("e",36);
mp.put("f",87);
mp.put("z",99);
mp.getOrDefault("A" ,10);
            System.out.println(mp.containsKey("A"));
        System.out.println(mp);

        Map<String,Integer> mp1 =new TreeMap<>();
            System.out.println(  mp1.put("A",23));
        mp1.put("b",45);
        mp1.put("c",13);
        mp1.put("z",34);
        mp1.put("e",36);
        System.out.println(mp1);
        TreeMap<Integer, String> map = new TreeMap<>();

        map.put(10, "A");
        map.put(20, "B");
        map.put(30, "C");
        map.put(40, "D");
        map.put(50, "E");
            System.out.println(map.get(30));

        for( Map.Entry<Integer, String> ss:map.entrySet())
        {
                System.out.println(ss.getKey()+" "+ss.getValue());
        }

        System.out.println(map);
        System.out.println("headMap: "+map.headMap(30));
        System.out.println("headmap: "+map.headMap(30, true));
        System.out.println("tailMap:"+map.tailMap(30));
        System.out.println("tailMap:"+map.tailMap(30, false));

        Map<Integer, String> head = map.headMap(30);
        head.put(15, "X");
        System.out.println(map);
        System.out.println("head:"+head);






    }
}
