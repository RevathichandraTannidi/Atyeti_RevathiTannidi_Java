package oops.oopsGFG;

public class Employee {
    private String name;
    private int id;
    private String department;

    public Employee(String name) {
        this.name = name;
    }

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Employee(String name, int id, String department) {
        this.name = name;
        this.id = id;
        this.department = department;
    }
    public void display()
    {
        System.out.println("Name: " + name);
        if (id != 0) {
            System.out.println("ID: " + id);
        }
        if (department != null) {
            System.out.println("Department: " + department);
        }
    }

    public static void main(String[] args) {
        System.out.println("name");
        Employee e=new Employee("revathi");
        e.display();
        System.out.println("\n name and id ");
        e=new Employee("revathi",23);
        e.display();
        System.out.println("\n name,,id and dept");
        e=new Employee("revathi",102,"it");
        e.display();
    }
}
