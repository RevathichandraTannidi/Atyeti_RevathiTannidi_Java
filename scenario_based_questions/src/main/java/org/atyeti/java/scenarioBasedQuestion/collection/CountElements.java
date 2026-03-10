package org.atyeti.java.scenarioBasedQuestion.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CountElements {
    public static void main(String[] args) {
     List<Integer> li= Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,13,12,14,15,16);
     List<Integer> s1=li.stream().filter(x->x%2==0).collect(Collectors.toList());
        List<Integer> s=li.parallelStream().filter(x->x%2==0).collect(Collectors.toList());
        System.out.println("streams :"+s1);
        System.out.println("parallel streams:"+s);

        List<Character> characters = new ArrayList<>();
        for (char character = 'A'; character <= 'Z'; character++) {
            characters.add(character);
        }
        System.out.println(characters);
    }
}
