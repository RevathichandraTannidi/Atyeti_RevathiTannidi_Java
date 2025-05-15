package conditionalStatements;

import java.util.Scanner;

public class Student_grade {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter marks for Physics: ");
        int physics = scanner.nextInt();
        System.out.print("Enter marks for Chemistry: ");
        int chemistry = scanner.nextInt();
        System.out.print("Enter marks for Biology: ");
        int biology = scanner.nextInt();
        System.out.print("Enter marks for Mathematics: ");
        int mathematics = scanner.nextInt();
        System.out.print("Enter marks for Computer: ");
        int computer = scanner.nextInt();
        int totalMarks = physics + chemistry + biology + mathematics + computer;
        double percentage = (totalMarks / 500.0) * 100;
        char grade;
        if (percentage >= 90) {
            grade = 'A';
        } else if (percentage >= 80) {
            grade = 'B';
        } else if (percentage >= 70) {
            grade = 'C';
        } else if (percentage >= 60) {
            grade = 'D';
        } else if (percentage >= 40) {
            grade = 'E';
        } else {
            grade = 'F';
        }
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Percentage: %.2f%%\n", percentage);
        System.out.println("Grade: " + grade);

        scanner.close();
            }
        }


