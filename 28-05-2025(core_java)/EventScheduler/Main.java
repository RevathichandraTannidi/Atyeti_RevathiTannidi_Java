import utils.DateTimeUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        EventManager manager = new EventManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n==== Event Scheduler ====");
            System.out.println("1. Add Event");
            System.out.println("2. View All Events");
            System.out.println("3. Upcoming Events");
            System.out.println("4. Time Until an Event");
            System.out.println("5. Events in Date Range");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");            switch (choice) {
                case 1 -> {
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter description: ");
                    String desc = scanner.nextLine();
                    System.out.print("Enter date & time (dd-MM-yyyy HH:mm): ");
                    String input = scanner.nextLine();
                    manager.addEvent(new Event(title, desc, DateTimeUtils.parse(input)));
                    System.out.println("Event added!");
                }
                case 2 -> {
                    List<Event> events = manager.getAllEvents();
                    events.forEach(System.out::println);
                }
                case 3 -> {
                    List<Event> upcoming = manager.getUpcomingEvents();
                    upcoming.forEach(System.out::println);
                }
                case 4 -> {
                    System.out.print("Enter event title to check time until: ");
                    String t = scanner.nextLine();
                    manager.getAllEvents().stream()
                            .filter(e -> e.getTitle().equalsIgnoreCase(t))
                            .findFirst()
                            .ifPresentOrElse(e -> {
                                System.out.println("Time left: " + manager.timeUntilEvent(e).toHours() + " hours");
                            }, () -> System.out.println("Event not found."));
                }
                case 5 -> {
                    System.out.print("Enter start date (dd-MM-yyyy): ");
                    String s = scanner.nextLine();
                    System.out.print("Enter end date (dd-MM-yyyy): ");
                    String e = scanner.nextLine();
                    List<Event> rangeEvents = manager.getEventsBetween(
                            LocalDate.parse(s, DateTimeUtils.formatter),
                            LocalDate.parse(e, DateTimeUtils.formatter)
                    );
                    rangeEvents.forEach(System.out::println);
                }
                case 0 -> running = false;
                default -> System.out.println("Invalid option.");
            }
        }
    }
}
