package inheritance.hospital_System;

public class HospitalEmployee {
    String name;
    int age;
    String department;

    HospitalEmployee(String name, int age, String department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Department: " + department);
    }
}