

    import java.time.LocalDate;
    import java.time.ZoneId;
    import java.time.ZoneOffset;
    import java.time.ZonedDateTime;

    public class ZonedDate {
        public static void main(String[] args) {
            LocalDate date = LocalDate.now();
            System.out.println("Current Date: " + date);
            ZonedDateTime dateTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
            ZonedDateTime DateT=ZonedDateTime.now(ZoneId.of("America/Chicago"));

             System.out.println("america time zone :" +DateT);

            System.out.println("Current Date and Time with Time Zone: " + dateTime);

            ZoneOffset offset = ZoneOffset.ofHours(5);
            ZonedDateTime dateTimeWithOffset = ZonedDateTime.now(offset);
            System.out.println("ZonedDateTime with Offset: " + dateTimeWithOffset);
        }
    }
