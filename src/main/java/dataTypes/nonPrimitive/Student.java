package dataTypes.nonPrimitive;

import java.util.Arrays;
import java.util.List;

public class Student {
    String name;
    int age;
    List<String> courses;

    public Student(String name, int age, List<String> courses) {
        this.name = name;
        this.age = age;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", courses=" + courses +
                '}';
    }

    public static void main(String[] args) {
         List<String> courses= Arrays.asList("python","java","#net","data Bi");
         Student s=new Student("revathi",22,courses);
        System.out.println(s);

    }
}
