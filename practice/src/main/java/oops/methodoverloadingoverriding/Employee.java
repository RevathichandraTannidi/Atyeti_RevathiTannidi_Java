package oops.methodoverloadingoverriding;

import java.util.Objects;

public class Employee {
    private int id;
    private String name;
    private String department;

    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(name, employee.name) && Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, department);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

}
class emp{
    public static void main(String[] args) {
        Employee ep1=new Employee(1,"kan","sal");
        Employee emp2 = new Employee(1, "Alice", "HR");
        Employee emp3 = new Employee(2, "Bob", "IT");

        System.out.println(ep1.equals(emp2));
    }
}
