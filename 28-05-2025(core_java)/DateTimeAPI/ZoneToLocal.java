

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZoneToLocal {
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        LocalDate localDate = zonedDateTime.toLocalDate();
        System.out.println("LocalDate: " + localDate);
    }
}
