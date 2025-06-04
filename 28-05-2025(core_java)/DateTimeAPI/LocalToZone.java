

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class LocalToZone {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.of("Asia/Kolkata"));
        System.out.println("ZonedDateTime: " + zonedDateTime);
    }

}
