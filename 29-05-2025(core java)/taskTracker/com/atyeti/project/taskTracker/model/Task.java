package com.atyeti.project.taskTracker.model;



import java.time.LocalDate;

public class Task {
    private final int id;
    private final String title;
    private final String category;
    private final LocalDate dueDate;
    private final Priority priority;
    private boolean completed;

    public Task(int id, String title, String category, LocalDate dueDate, Priority priority) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.dueDate = dueDate;
        this.priority = priority;
        this.completed = false;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public LocalDate getDueDate() { return dueDate; }
    public Priority getPriority() { return priority; }
    public boolean isCompleted() { return completed; }

    public void markCompleted() {
        this.completed = true;
    }

    public boolean isOverdue() {
        return !completed && dueDate.isBefore(LocalDate.now());
    }

    @Override
    public String toString() {
        return id + ". [" + priority + "] " + title +
                " | Category: " + category +
                " | Due: " + dueDate +
                " | Status: " + (completed ? "✅ Done" : isOverdue() ? "⚠️ Overdue" : "⏳ Pending");
    }
}
