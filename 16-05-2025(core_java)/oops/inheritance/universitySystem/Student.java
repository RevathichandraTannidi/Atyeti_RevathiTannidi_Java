package inheritance.universitySystem;

public class Student extends Person {
    String studentId;
String course;

    public Student(String name, int age, String gender,String studentId,String course) {
        super(name,  age,gender);
        this.studentId=studentId;
        this.course=course;
    }
    @Override
    public void getDetails() {
        super.getDetails();
        System.out.println("student Id:"+studentId);
        System.out.println("course"+course);

    }


}
