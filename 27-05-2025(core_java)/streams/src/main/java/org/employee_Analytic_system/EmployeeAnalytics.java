package org.employee_Analytic_system;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import static java.util.stream.Collectors.*;


import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;

public class EmployeeAnalytics {
    public static void main(String[] args) {
        List<Employee> employee=new ArrayList<>();
     final String inputfile="C:\\Users\\RevathiTannidi\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_RevathiTannidi_Java\\27-05-2025(core_java)\\streams\\src\\main\\java\\org\\employee_Analytic_system\\employees.csv";

        try(BufferedReader br=new BufferedReader(new FileReader(inputfile))) {
            br.readLine();
            String line="";
            while((line= br.readLine())!=null)
            {

                String[] data=line.split(",");
                Employee emp1=new Employee(Integer.parseInt(data[0]),data[1],data[2],Double.parseDouble(data[3]),LocalDate.parse(data[4]));
                employee.add(emp1);
            }
            System.out.println(employee);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        Map<String, Optional<Employee>> highestPaidByDept = employee.stream()
                .collect(groupingBy(Employee::getDepartment, maxBy(Comparator.comparingDouble(Employee::getSalary))));
 highestPaidByDept.forEach((dept, emp1) -> System.out.println(dept + ": " + emp1.orElse(null)));

        System.out.println("\n");
        Map<Integer, Long> countByYear = employee.stream()
.collect(groupingBy(e -> e.getJoiningDate().getYear(), counting()));
 countByYear.forEach((year, count) -> System.out.println(year + ": " + count));



 Map<String, Double> avgSalaryByDept = employee.stream()
 .collect(groupingBy(Employee::getDepartment, averagingDouble(Employee::getSalary)));

 List<String> filteredEmployees = employee.stream()
.filter(e -> e.getJoiningDate().getYear() > 2018)
 .filter(e -> e.getSalary() > avgSalaryByDept.get(e.getDepartment()))
 .map(Employee::getName) .collect(toList());

 System.out.println("\nEmployees joined after 2018 and earn more than dept average:");
 filteredEmployees.forEach(System.out::println);


    }
}
