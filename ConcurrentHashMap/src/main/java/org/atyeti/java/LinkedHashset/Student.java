package org.atyeti.java.LinkedHashset;

//same hahscode different equals
import java.util.LinkedHashSet;

public class Student {
    int id;
    Student(int id) {
        this.id = id; }

    public int hashCode() {
        return 1; // same hash code for all
    }

    public boolean equals(Object o) {
        return true; // always false
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                '}';
    }

    public static void main(String[] args) {
        LinkedHashSet<Student> set = new LinkedHashSet<>();

        set.add(new Student(1));
        set.add(new Student(2));
        System.out.println(set);

    }

}

//if both a and b are have same hashcode different in equals like false
//both a and b go to the same bucket


//Bucket 5 → a → b


//doubl ylinked list
//a ⇄ b
//LinkedHashSet uses linked lists in two places: one for collision handling inside buckets,
// and another doubly linked list to maintain insertion order

//LinkedHashSet does not check variable values directly.
//It only checks equals() and hashCode()

//If equals() and hashCode() are not overridden, dummy values being same does not make the key same; objects are treated as different.”