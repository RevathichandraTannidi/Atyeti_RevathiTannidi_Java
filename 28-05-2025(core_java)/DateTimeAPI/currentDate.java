

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Locale;

public class currentDate {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        System.out.println("Current Date: " + currentDate);
        LocalTime currentTime = LocalTime.now();
        System.out.println("Current Time: " + currentTime);
        LocalDateTime currentDateT = LocalDateTime.now();
        System.out.println("Current Date and Time: " + currentDateT);
        LocalDate Date=LocalDate.now();
        System.out.println(Date.getDayOfYear());
    }
}
