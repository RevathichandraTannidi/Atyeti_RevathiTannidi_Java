

import java.time.LocalDate;
import java.time.LocalTime;

public class CurrentDatePlus {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        LocalDate futureDate = currentDate.plusDays(10);
        System.out.println("Date after 10 days: " + futureDate);
        LocalTime currentTime = LocalTime.now();
        LocalTime pastTime = currentTime.minusHours(5);
        System.out.println("Time 5 hours ago: " + pastTime);
        LocalDate currentDate1= LocalDate.now();
        LocalDate futureDate1 = currentDate1.plusMonths(3);
        System.out.println("Date after 3 months: " + futureDate1);
        LocalDate currentDate2 = LocalDate.now();
        LocalDate pastDate = currentDate2.minusWeeks(2);
        System.out.println("Date 2 weeks ago: " + pastDate);
    }
}
