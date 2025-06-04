

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class firstone {
    public static void main(String[] args) {
        LocalDateTime l= LocalDateTime.now();
        System.out.println("current time in laptop: " +l);
        LocalTime time= LocalTime.MIDNIGHT.withHour(2);
        System.out.println(time);
        LocalDate l2= LocalDate.of(2000,02,11);
        System.out.println(l2);
    }
}
