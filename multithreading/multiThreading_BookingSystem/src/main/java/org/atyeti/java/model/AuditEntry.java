package org.atyeti.java.model;

import java.time.LocalDateTime;

public class AuditEntry {
    private String action;
    private LocalDateTime time;

    public AuditEntry(String action) {
        this.action = action;
        this.time = LocalDateTime.now();
    }

    public String toString() {
        return "[" + time + "] " + action;
    }
}
