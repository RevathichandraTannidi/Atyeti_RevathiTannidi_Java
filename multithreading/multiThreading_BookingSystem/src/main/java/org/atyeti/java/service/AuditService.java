package org.atyeti.java.service;


import org.atyeti.java.model.AuditEntry;

import java.util.ArrayList;
import java.util.List;

public class AuditService {

    private static List<AuditEntry> auditLog = new ArrayList<>();

    public static void log(String action) {
        auditLog.add(new AuditEntry(action));
    }

    public static void showAuditHistory() {
        System.out.println("\n AUDIT LOG ");
        auditLog.forEach(System.out::println);
    }
}
