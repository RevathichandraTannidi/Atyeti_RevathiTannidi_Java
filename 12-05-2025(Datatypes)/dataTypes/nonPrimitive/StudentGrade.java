package dataTypes.nonPrimitive;

import java.util.ArrayList;
import java.util.List;

public class StudentGrade {
    String name;
    List<Double> grades;

    public StudentGrade(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Double> getGrades() {
        return grades;
    }



    public void addGrades(double grade)
    {
        grades.add(grade);
    }

    public double calculateAverageValues()
    {
        if(grades.isEmpty())
        {
            return 0.0;
        }
       double sum=0;
        for(double grade:grades)
        {
            sum+=grade;
        }

        return sum/grades.size();
    }

    @Override
    public String toString() {
        return "StudentGrade{" +
                "name='" + name + '\'' +
                ", grades=" + grades +
                '}';
    }

    public static void main(String[] args) {
        StudentGrade  sg=new StudentGrade("revathi chandra");
        sg.addGrades(92.0);
        sg.addGrades(70.4);
        sg.addGrades(88.4);
        sg.addGrades(84.6);
        System.out.println( "Average grades of the  student grades: "+sg.calculateAverageValues());
    }

}
