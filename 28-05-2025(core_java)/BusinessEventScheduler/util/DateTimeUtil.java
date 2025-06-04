package util;

import java.time.*;

public class DateTimeUtil {
    public static final ZoneId ZONE_ID = ZoneId.of("Asia/Kolkata");
    public static final LocalTime START_OF_DAY = LocalTime.of(9, 0);
    public static final LocalTime END_OF_DAY = LocalTime.of(17, 0);
    public static final Duration MEETING_DURATION = Duration.ofHours(1);

    public static boolean isWorkingHour(ZonedDateTime time) {
        DayOfWeek day = time.getDayOfWeek();
        LocalTime localTime = time.toLocalTime();
        return !(day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY)
                && !localTime.isBefore(START_OF_DAY)
                && !localTime.isAfter(END_OF_DAY.minus(MEETING_DURATION));
    }
}