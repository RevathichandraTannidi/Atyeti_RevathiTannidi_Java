package org.atyeti.java.LinkedHashset;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedIterator {


        public static void main(String[] args) {

            Set<String> lh = new LinkedHashSet<String>();

            lh.add("Geek");
            lh.add("For");
            lh.add("Geeks");
            lh.add("A");
            lh.add("B");
            lh.add("Z");

            Iterator itr = lh.iterator();

            while (itr.hasNext())
                System.out.print(itr.next() + ", ");

            System.out.println();

            for (String s : lh)
                System.out.print(s + ", ");
            System.out.println();
        }
    }

