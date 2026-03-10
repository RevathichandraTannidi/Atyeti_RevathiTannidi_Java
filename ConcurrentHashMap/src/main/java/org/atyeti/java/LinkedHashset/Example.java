package org.atyeti.java.LinkedHashset;

import java.util.LinkedHashSet;

public class Example {
    public static void main(String[] args) {
        LinkedHashSet<String> li=new LinkedHashSet<>();
        li.add("tree");
        li.add("Book");
             li.add(null);
    li.add("Sindu");
    li.add(null);
    li.add("sum");
      li.add("revs");
        System.out.println("the hash set elements are :\n" +li);

        System.out.println("\nIterating through elements:");
        for (String si : li) {
     //       li.add("reun");
            li.remove("revs");
            System.out.println("Element: " + si);
        }

        // A few common operations
        System.out.println("\nContains 'tree'? " + li.contains("tree"));
        System.out.println("Contains 'Tree'? " + li.contains("Tree")); // case-sensitive
        System.out.println("Size: " + li.size());
        System.out.println("Removed 'Book: " + li.remove("Book"));
        System.out.println("After removal: " + li);

    }
}
