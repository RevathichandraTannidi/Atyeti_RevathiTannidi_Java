

import java.time.Year;

public class LEapYear {
    public static void main(String[] args) {
        Year year = Year.of(2025);
        boolean isLeap = year.isLeap();
        System.out.println("Is 2024 a leap year? " + isLeap);
    }
}
