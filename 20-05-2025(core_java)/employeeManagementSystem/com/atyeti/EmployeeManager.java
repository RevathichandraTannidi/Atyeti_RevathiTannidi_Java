package com.atyeti;
import java.io.*;
import java.util.*;

public class EmployeeManager {
    private Map<Integer, Employee> employees = new HashMap<>();
    private final String filePath = "employees.csv";

    public EmployeeManager() {
        loadFromFile();
    }

    private void loadFromFile() {
        File file = new File(filePath);
        if (!file.exists()) {

            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length != 5) continue; // Skip invalid lines
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                String department = data[3];
                double salary = Double.parseDouble(data[4]);
                Employee emp = new Employee(id, name, age, department, salary);
                employees.put(id, emp);
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }

    private void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Employee emp : employees.values()) {
                bw.write(emp.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    public void addEmployee(Employee emp) {
        if (employees.containsKey(emp.getId())) {
            System.out.println("Employee with ID " + emp.getId() + " already exists.");
            return;
        }
        employees.put(emp.getId(), emp);
        saveToFile();
        System.out.println("Employee added successfully.");
    }

    public void updateEmployee(int id, String name, int age, String department, double salary) {
        Employee emp = employees.get(id);
        if (emp == null) {
            System.out.println("Employee with ID " + id + " not found.");
            return;
        }
        emp.setName(name);
        emp.setAge(age);
        emp.setDepartment(department);
        emp.setSalary(salary);
        saveToFile();
        System.out.println("Employee updated successfully.");
    }

    public void deleteEmployee(int id) {
        if (employees.remove(id) != null) {
            saveToFile();
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    public void viewAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        System.out.println("ID\tName\tAge\tDepartment\tSalary");
        for (Employee emp : employees.values()) {
            System.out.printf("%d\t%s\t%d\t%s\t%.2f%n",
                    emp.getId(), emp.getName(), emp.getAge(),
                    emp.getDepartment(), emp.getSalary());
        }
    }

    public void searchEmployee(int id) {
        Employee emp = employees.get(id);
        if (emp != null) {
            System.out.println("Employee Found:");
            System.out.println("ID: " + emp.getId());
            System.out.println("Name: " + emp.getName());
            System.out.println("Age: " + emp.getAge());
            System.out.println("Department: " + emp.getDepartment());
            System.out.println("Salary: " + emp.getSalary());
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }
}
