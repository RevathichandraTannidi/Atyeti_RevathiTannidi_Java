package operators;

class Animal {

}
class Dog extends Animal {

}
class Cat extends Animal {

}

public class InstanceofExample1 {
    public static void main(String[] args) {
        Animal animal1 = new Dog();
        Animal animal2 = new Cat();
        Animal animal3 = new Animal();

        System.out.println("animal1 is instance of Dog: " + (animal1 instanceof Dog));
        System.out.println("animal2 is instance of Cat: " + (animal2 instanceof Cat));
        System.out.println("animal3 is instance of Animal: " + (animal3 instanceof Animal));
        System.out.println("animal1 is instance of Animal: " + (animal1 instanceof Animal));
        System.out.println("animal2 is instance of Animal: " + (animal2 instanceof Animal));
        System.out.println("animal3 is instance of Dog: " + (animal3 instanceof Dog));
    }
}
