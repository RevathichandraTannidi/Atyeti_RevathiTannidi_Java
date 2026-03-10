package org.atyeti.java.practice;

import java.util.HashMap;
import java.util.Map;

public class CharacterCount {
    public static void main(String[] args) {
        String s="Hi revathi chandra how are you";
        Map<Character,Integer> mp=new HashMap<>();
        for(char c:s.toCharArray())
        {
            mp.put(c,mp.getOrDefault(c,0) +1);

        }

        System.out.println("character occurances");
        for(Map.Entry<Character,Integer> entry :mp.entrySet()){
        System.out.println(" "+entry.getKey() + "  -> "+entry.getValue());
        }
    }
}
