package collections;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class mappp {
    public static void main(String[] args) {

               TreeMap<Employee, Integer> m = new TreeMap<>();
                m.put(new Employee(1), 1);
                m.put(new Employee(1), 2); // same id: compareTo returns 0 -> key is considered equal
                m.put(new Employee(2), 3);

                System.out.println(m.size()); // size depends on compareTo logic
                System.out.println(m);
            }
        }

        class Employee implements Comparable<Employee> {
            private int id;

            public Employee(int id) {
                this.id = id;
            }

            @Override
            public int compareTo(Employee other) {
                return Integer.compare(this.id, other.id);
            }

            @Override
            public String toString() {
                return "Employee{id=" + id + "}";
            }
        }

