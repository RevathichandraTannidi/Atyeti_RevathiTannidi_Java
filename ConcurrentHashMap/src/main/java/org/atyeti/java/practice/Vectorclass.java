package org.atyeti.java.practice;

import java.util.Stack;
import java.util.Vector;

public class Vectorclass {
    public static void main(String [] args)
    {
        Vector<Integer> v= new Vector<>(3,2);
        v.add(1);
        v.add(2);
        v.add(3);
        v.add(4);
        v.remove(1);
        System.out.println(v);

        Stack s=new Stack<>();
        

    }
}
