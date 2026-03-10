package org.atyeti.java.scenarioBasedQuestion.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class student
{
    private String name;
    private int id;

    public student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
public class CustomComporator {
    public static void main(String[] args) {

        List<student> li= Arrays.asList(new student("revathi",23),
                new student("someswari",45),
                new student("sowmya",12),
                new student("arjun",87));

       li.sort(Comparator.comparingInt(student::getId));
        System.out.println(li);

    }
}
