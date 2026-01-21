package oops.methodoverloadingoverriding;

import java.util.ArrayList;
import java.util.List;

public abstract class Animal {
    abstract void makeSound();
}
class Dog extends Animal{

    @Override
    void makeSound() {
        System.out.println("Woof!");
    }
}
 class Cat extends Animal
 {

     @Override
     void makeSound() {
         System.out.println("Meow!");
     }

     public static void main(String[] args) {
         Animal a=new Dog();
         a.makeSound();
         Animal b=new Cat();
         b.makeSound();
         List<Animal> li =new ArrayList<>();
        li.add(new Cat());
        li.add(new Dog());
        li.add(new Dog());
        li.add(new Cat());
         System.out.println("\nAll animals making sound:");
         for (Animal animal : li) {
             animal.makeSound(); // Polymorphism in action!
         }
     }
 }