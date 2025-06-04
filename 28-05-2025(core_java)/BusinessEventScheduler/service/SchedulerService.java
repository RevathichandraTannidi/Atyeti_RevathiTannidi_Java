package service;

import model.Meeting;
import util.DateTimeUtil;

import java.time.*;
import java.util.*;

public class SchedulerService {
    private final NavigableSet<ZonedDateTime> scheduledSlots = new TreeSet<>();
    private final Map<ZonedDateTime, Meeting> meetings = new TreeMap<>();

    public void schedule(String title) {
        ZonedDateTime slot = findNextAvailableSlot();
        meetings.put(slot, new Meeting(title, slot));
        scheduledSlots.add(slot);
        System.out.println("Scheduled: " + title + " at " + slot);
    }

    private ZonedDateTime findNextAvailableSlot() {
        ZonedDateTime now = ZonedDateTime.now(DateTimeUtil.ZONE_ID);
        ZonedDateTime candidate = now.withHour(DateTimeUtil.START_OF_DAY.getHour()).withMinute(0).withSecond(0).withNano(0);

        if (now.toLocalTime().isAfter(DateTimeUtil.END_OF_DAY)) {
            candidate = candidate.plusDays(1);
        } else if (now.toLocalTime().isAfter(DateTimeUtil.START_OF_DAY)) {
            candidate = now.withSecond(0).withNano(0);
        }

        while (true) {
            if (DateTimeUtil.isWorkingHour(candidate) && !scheduledSlots.contains(candidate)) {
                return candidate;
            }
            candidate = candidate.plus(DateTimeUtil.MEETING_DURATION);
            if (candidate.toLocalTime().isAfter(DateTimeUtil.END_OF_DAY)) {
                candidate = candidate.plusDays(1).withHour(DateTimeUtil.START_OF_DAY.getHour()).withMinute(0);
            }
        }
    }

    public void listEvents(LocalDate date) {
        System.out.println("Meetings on " + date + ":");
        meetings.values().stream()
                .filter(m -> m.getStartTime().toLocalDate().equals(date))
                .forEach(System.out::println);
    }

    public void countEventsThisWeek() {
        ZonedDateTime now = ZonedDateTime.now(DateTimeUtil.ZONE_ID);
        LocalDate startOfWeek = now.with(DayOfWeek.MONDAY).toLocalDate();
        LocalDate endOfWeek = now.with(DayOfWeek.SUNDAY).toLocalDate();

        long count = meetings.values().stream()
                .filter(m -> {
                    LocalDate d = m.getStartTime().toLocalDate();
                    return !d.isBefore(startOfWeek) && !d.isAfter(endOfWeek);
                }).count();

        System.out.println("Meetings this week: " + count);
    }
}