package org.atyeti.java.scenarioBasedQuestion.collection;

import java.util.ArrayList;
import java.util.List;

public class Program1 {
    public static void main(String[] args) {
         List<String> names=new ArrayList<>();
         names.add("revathi");
         names.add("chandra");
         for (String s:names)
         {
             System.out.println(s);
         }
    }
}
