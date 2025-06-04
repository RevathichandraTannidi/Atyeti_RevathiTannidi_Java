import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EventManager {
    private List<Event> events=new ArrayList<>();

    public void addEvent(Event event) {
events.add(event);
    }

    public List<Event> getAllEvents() {
        return new ArrayList<>(events);
    }

    public List<Event> getUpcomingEvents() {
        LocalDateTime now = LocalDateTime.now();
        return events.stream()
                .filter(e -> e.getDateTime().isAfter(now))
                .sorted(Comparator.comparing(Event::getDateTime))
                .collect(Collectors.toList());
    }

    public Duration timeUntilEvent(Event event) {
        return Duration.between(LocalDateTime.now(), event.getDateTime());
    }

    public List<Event> getEventsBetween(LocalDate start, LocalDate end) {
        return events.stream()
                .filter(e -> {
                    LocalDate eventDate = e.getDateTime().toLocalDate();
                    return (eventDate.isEqual(start) || eventDate.isAfter(start)) &&
                            (eventDate.isEqual(end) || eventDate.isBefore(end));
                })
                .collect(Collectors.toList());
    }
}
