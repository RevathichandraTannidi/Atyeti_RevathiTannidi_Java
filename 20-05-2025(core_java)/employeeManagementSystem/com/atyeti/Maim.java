package com.atyeti;


import java.util.Scanner;

public class Maim {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n Employee Management System ");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. View All Employees");
            System.out.println("5. Search Employee");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Please enter a valid number: ");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter ID: ");
                        int id = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Age: ");
                        int age = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter Department: ");
                        String department = sc.nextLine();
                        System.out.print("Enter Salary: ");
                        double salary = Double.parseDouble(sc.nextLine());
                        Employee emp = new Employee(id, name, age, department, salary);
                        manager.addEmployee(emp);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input.");
                    }
                    break;
                case 2:
                    try {
                        System.out.print("Enter ID of the employee to update: ");
                        int id = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter New Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter New Age: ");
                        int age = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter New Department: ");
                        String department = sc.nextLine();
                        System.out.print("Enter New Salary: ");
                        double salary = Double.parseDouble(sc.nextLine());
                        manager.updateEmployee(id, name, age, department, salary);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter correct data types.");
                    }
                    break;
                case 3:
                    try {
                        System.out.print("Enter ID of the employee to delete: ");
                        int id = Integer.parseInt(sc.nextLine());
                        manager.deleteEmployee(id);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID. Please enter a valid number.");
                    }
                    break;
                case 4:
                    manager.viewAllEmployees();
                    break;
                case 5:
                    try {
                        System.out.print("Enter ID of the employee: ");
                        int id = Integer.parseInt(sc.nextLine());
                        manager.searchEmployee(id);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid .");
                    }
                    break;
                case 6:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 6);


    }
}
