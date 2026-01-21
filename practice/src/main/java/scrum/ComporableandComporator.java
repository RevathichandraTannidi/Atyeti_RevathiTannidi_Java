package scrum;

public class ComporableandComporator {
    public static void main(String[] args) {
        Employee e=new Employee(1,"vamshi");
        Employee e1=new Employee(23,"savitri");
        Employee e2=new Employee(4,"sowjanya");
        Employee e3 =new Employee(5,"someswari");
        Employee e4=new Employee(67,"achyuth");



    }
}

class Employee
{
    int id;
    String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}