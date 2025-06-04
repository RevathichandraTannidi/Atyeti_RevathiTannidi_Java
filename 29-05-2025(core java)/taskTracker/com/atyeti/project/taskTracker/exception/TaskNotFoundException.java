package com.atyeti.project.taskTracker.exception;

public class TaskNotFoundException  extends RuntimeException{
    public TaskNotFoundException(int id) {
        super("Task with ID " + id + " not found.");
    }
}
