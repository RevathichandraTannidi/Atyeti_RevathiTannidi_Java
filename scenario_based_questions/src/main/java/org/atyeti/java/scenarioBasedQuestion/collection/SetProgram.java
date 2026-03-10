package org.atyeti.java.scenarioBasedQuestion.collection;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetProgram {
    public static void main(String[] args) {
     List<String> s=List.of("A","B","C","A","B","D");
     Set<String>  ss=new TreeSet<>(s);
        System.out.println(ss);
    }
}
