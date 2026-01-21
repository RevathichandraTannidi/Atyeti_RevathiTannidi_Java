package Mapss;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Example2 {
    public static void main(String[] args) {
        Map<Integer[], String> map = new HashMap<>();
        map.put(new Integer[]{6,2,3,4},"reva");
        map.put(new Integer[]{8,6,4,1},"zebra");
        map.put(new Integer[]{1,3,5,6},"karanam");
        map.put(new Integer[]{1,4,5,6},"somi");
for(Map.Entry<Integer[], String> entry:map.entrySet())
{
    System.out.println(Arrays.toString(entry.getKey())+" "+entry.getValue());
}


    }
}
