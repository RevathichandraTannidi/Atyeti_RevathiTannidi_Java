package org.atyeti.java.LinkedHashset;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class HAshVsLinked {
    public static void main(String[] args) {

        HashSet<String> hashSet = new HashSet<>(Arrays.asList("A", "B", "C","D","E","F"));
        System.out.println(hashSet);
        LinkedHashSet<String> linkedSet = new LinkedHashSet<>(Arrays.asList("A", "B", "C"));
        System.out.println(linkedSet);
    }
}
