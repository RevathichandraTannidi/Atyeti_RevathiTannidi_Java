package conditionalStatements;

import java.util.Scanner;

public class Salary_calculator {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
System.out.print("Enter the basic salary: ₹");
double basicSalary = scanner.nextDouble();
double hra, da;
int salaryRange = (basicSalary <= 10000) ? 1 : (basicSalary <= 20000) ? 2 : 3;

        switch (salaryRange) {
                case 1:
                hra = basicSalary * 0.20;
                    da = basicSalary * 0.80;
                break;
                case 2:
                hra = basicSalary * 0.25;
                da = basicSalary * 0.90;
                        break;
                case 3:
                hra = basicSalary * 0.30;
                da = basicSalary * 0.95;
              break;
                    default:
                    hra = 0;
                    da = 0;
                    break;
}

        double grossSalary = basicSalary + hra + da;
        System.out.printf("Basic Salary: %.2f\n", basicSalary);
        System.out.printf("HRA:  %.2f\n", hra);
        System.out.printf("DA:  %.2f\n", da);
        System.out.printf("Gross Salary: ₹%.2f\n", grossSalary);


    }
}
