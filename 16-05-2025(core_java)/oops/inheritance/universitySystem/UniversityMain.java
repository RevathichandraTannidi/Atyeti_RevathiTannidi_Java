package inheritance.universitySystem;

public class UniversityMain {
    public static void main(String[] args) {

 Person p1 = new Student("revathi chandra", 22, "Female", "S123", "Computer Science");
 Person p2 = new Professor("Dr. Someswari", 45, "Female", "P456", "python");
 System.out.println("Student Details");
 p1.getDetails();

 System.out.println("\n Professor Details");
 p2.getDetails();

    }
}
