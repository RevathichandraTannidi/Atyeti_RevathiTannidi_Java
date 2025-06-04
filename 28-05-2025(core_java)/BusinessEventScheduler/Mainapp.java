import service.SchedulerService;

import java.time.LocalDate;

public class Mainapp {
    public static void main(String[] args) {
        SchedulerService scheduler = new SchedulerService();

        scheduler.schedule("Quarterly Review");
        scheduler.schedule("Client Sync");
        scheduler.schedule("Finance Audit");

        scheduler.listEvents(LocalDate.now());
        scheduler.countEventsThisWeek();
    }
}
