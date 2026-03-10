package org.atyeti.java.LinkedHashset;

import java.util.LinkedHashSet;

public class Student2 {
    int id;
    Student2(int id) {
        this.id = id; }

    @Override
    public String toString() {
        return "Student2{" +
                "id=" + id +
                '}';
    }

    public static void main(String[] args) {
        LinkedHashSet<Student2> set = new LinkedHashSet<>();

        set.add(new Student2(1));
        set.add(new Student2(1));
        System.out.println(set);
    }
}

//“Even if values are same, keys are different if equals and hashCode are not overridden.
//What YOU see
//
//Both have id = 1 (dummy value looks same)
//
//What JAVA sees
//
//Two different objects
//
//Two different memory addresses
//
//Two different hashCodes
//
//equals() → compares references → false