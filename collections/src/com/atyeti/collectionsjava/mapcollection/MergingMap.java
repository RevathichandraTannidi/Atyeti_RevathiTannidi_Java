package com.atyeti.collections.mapcollection;
import java.util.*;
public class MergingMap {
    public static Map<String, Object> deepMerge(Map<String, Object> m1, Map<String, Object> m2) {
        Map<String, Object> res = new HashMap<>(m1);
        for (Map.Entry<String, Object> entry : m2.entrySet()) {
             String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Map && res.containsKey(key) && res.get(key) instanceof Map) {
                 res.put(key, deepMerge((Map<String, Object>) res.get(key), (Map<String, Object>) value));
            } else {
                res.put(key, value);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Map<String, Object> map1 = Map.of("a", 1, "b", Map.of("c", 3));
    Map<String, Object> map2 = Map.of("a", 2, "b", Map.of("d", 4), "e", 5);
        System.out.println(deepMerge(map1,map2));
    }
}


//Map<String, Object> map1 = Map.of("a", 1, "b", Map.of("c", 3));
//Map<String, Object> map2 = Map.of("a", 2, "b", Map.of("d", 4), "e", 5);

//Write a function to deep merge them so that:
//
//Primitive values are overwritten by map2
//Maps are merged recursively
// Concepts:
//Recursion
//Type checking with instanceof
//Using computeIfPresent() or manual logic