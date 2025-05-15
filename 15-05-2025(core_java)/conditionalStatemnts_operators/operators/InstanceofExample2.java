package operators;
interface Pet {

}
class Dog1 implements Pet {

}
class Cat1 implements Pet {

}

public class InstanceofExample2 {
    public static void main(String[] args) {
        Pet pet1 = new Dog1();
        Pet pet2 = new Cat1();

        System.out.println("pet1 is instance of Dog: " + (pet1 instanceof Dog1));
        System.out.println("pet2 is instance of Cat: " + (pet2 instanceof Cat1));
        System.out.println("pet1 is instance of Pet: " + (pet1 instanceof Pet));
        System.out.println("pet2 is instance of Pet: " + (pet2 instanceof Pet));
    }
}

