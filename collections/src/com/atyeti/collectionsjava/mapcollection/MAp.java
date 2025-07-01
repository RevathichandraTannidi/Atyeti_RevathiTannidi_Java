package com.atyeti.collections.mapcollection;
import  java.util.*;
public class MAp {
    public static void main(String[] args) {
        Map<Integer,String> map=new HashMap<>();
        map.put(123,"rev");
        map.put(124,"chand");
        map.put(125,"sandd");
        map.put(126,"rAAMDU");
        map.put(129,"sandru");
        System.out.println(map);


        for(Integer keys: map.keySet())
        {
            System.out.println(keys);
        }

        System.out.println(map);
        map.remove(129);
        System.out.println(map);

        System.out.println(map.containsKey(124));
        map.put(126,"sunny");
        System.out.println(map);

    }
}
