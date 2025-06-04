package model;


import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Meeting {
    private final String title;
    private final ZonedDateTime startTime;

    public Meeting(String title, ZonedDateTime startTime) {
        this.title = title;
        this.startTime = startTime;
    }

    public String getTitle() {
        return title;
    }

    public ZonedDateTime getStartTime() {
        return startTime;
    }

    @Override
    public String toString() {
        return title + " @ " + startTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm z"));
    }
}
