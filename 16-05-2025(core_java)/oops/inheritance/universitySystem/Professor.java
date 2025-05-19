package inheritance.universitySystem;

public class Professor extends Person{
    String employeeId;
    String department;


 Professor(String name,  int age, String gender,String employeeId,
    String department) {
        super(name, age,gender);
        this.department=department;
        this.employeeId=employeeId;
    }

    @Override
    public void getDetails() {
     super.getDetails();
        System.out.println("department of the employee"+employeeId);
        System.out.println("department of the employee"+department);
    }


}
