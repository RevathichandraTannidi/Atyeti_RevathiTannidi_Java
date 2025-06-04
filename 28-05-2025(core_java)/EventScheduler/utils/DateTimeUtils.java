package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    public static LocalDateTime parse(String input) {
        return LocalDateTime.parse(input, formatter);
    }

    public static String format(LocalDateTime dateTime) {
        return dateTime.format(formatter);
    }
}
