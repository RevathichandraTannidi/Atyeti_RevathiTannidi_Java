package inheritance.universitySystem;

public class Person {
String name;
String gender;
int age;

    public Person(String name,  int age,String gender) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public void getDetails()
    {
        System.out.println("The name of the studnt"+name);
        System.out.println("The gender of the student"+gender);
        System.out.println("the age of the student"+age);
    }
}
