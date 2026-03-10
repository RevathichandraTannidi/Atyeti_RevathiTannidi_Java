package org.atyeti.java.LinkedHashset;

import java.util.LinkedHashSet;

public class Studennt1 {
        int id;
        Studennt1(int id) {
            this.id = id;
        }

    @Override
    public int hashCode() {
     return id;
    }

    @Override
    public boolean equals(Object o) {
        Studennt1 s = (Studennt1) o;
        return this.id == s.id;
    }

    @Override
    public String toString() {
        return "Studennt1{" +
                "id=" + id +
                '}';
    }

    public static void main(String[] args) {
        LinkedHashSet<Studennt1> set = new LinkedHashSet<>();

        set.add(new Studennt1(1));
        set.add(new Studennt1(2));
        set.add(new Studennt1(1));
        System.out.println(set);
      //  System.out.println(set.size());

    }
}
//newKey.equals(existingKey)



//equals() is used to compare the NEW element (key) with
// EXISTING keys already present in the LinkedHashSet. its key vs key comparison
//equals() never compares with a “value” in LinkedHashSet.
//It compares the incoming key with existing key
//What JAVA sees now
//
//Same hashCode
//
//equals() returns true
//
//Result
//
//Second object rejected (duplicate)
//
//Correct statement
//
//“After overriding equals and hashCode, objects with same data are treated as same key.”