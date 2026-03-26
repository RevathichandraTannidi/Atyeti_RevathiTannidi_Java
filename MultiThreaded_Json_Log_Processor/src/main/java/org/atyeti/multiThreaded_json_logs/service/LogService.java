package org.atyeti.multiThreaded_json_logs.service;


import org.atyeti.multiThreaded_json_logs.model.LogEntry;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class LogService {

    private ConcurrentHashMap<String, AtomicInteger> errorCount = new ConcurrentHashMap<>();

    public void process(LogEntry log) {

        if (log == null) return;

        if ("ERROR".equals(log.getLevel())) {

            errorCount
                    .computeIfAbsent(log.getService(), k -> new AtomicInteger(0))
                    .incrementAndGet();
        }
    }

    public void printResults() {
        System.out.println("ERROR count per service:");
        errorCount.forEach((service, count) ->
                System.out.println(service + " -> " + count.get())
        );
    }
}