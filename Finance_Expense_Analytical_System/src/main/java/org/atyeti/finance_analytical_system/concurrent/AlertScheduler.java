package org.atyeti.finance_analytical_system.concurrent;

import org.atyeti.finance_analytical_system.model.Transaction;
import org.atyeti.finance_analytical_system.service.BudgetAlertService;

import java.util.List;
import java.util.concurrent.*;

public class AlertScheduler {

    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public void start(List<Transaction> list, double budget) {

        BudgetAlertService service = new BudgetAlertService();

        scheduler.scheduleAtFixedRate(() -> {
            service.checkAndNotify(list, budget);
        }, 0, 10, TimeUnit.SECONDS); // every 10 sec (demo)
    }
}