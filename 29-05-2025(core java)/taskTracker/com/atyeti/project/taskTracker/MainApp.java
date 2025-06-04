package com.atyeti.project.taskTracker;

import com.atyeti.project.taskTracker.service.TaskManager;
import com.atyeti.project.taskTracker.service.TaskManagerImpl;

public class MainApp {
    public static void main(String[] args) {
        TaskManager manager = new TaskManagerImpl();

        manager.addTask("Finish report", "Work", "2025-06-10", "HIGH");
        manager.addTask("Doctor Appointment", "Health", "2025-06-05", "MEDIUM");
        manager.addTask("rani", "Personal", "2025-06-01", "LOW");

        System.out.println(" All Tasks:");
        manager.getAllTasks().forEach(System.out::println);
        manager.markTaskCompleted(2);
        System.out.println("\n Completed Tasks:");
        manager.getCompletedTasks().forEach(System.out::println);

        System.out.println("\n Overdue Tasks:");
        manager.getOverdueTasks().forEach(System.out::println);

        System.out.println("\n Tasks by Priority:");
        manager.getTasksSortedByPriority().forEach(System.out::println);
    }
}
