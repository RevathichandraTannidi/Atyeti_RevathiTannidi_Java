package com.atyeti.project.taskTracker.service;

import com.atyeti.project.taskTracker.exception.TaskNotFoundException;
import com.atyeti.project.taskTracker.model.Priority;
import com.atyeti.project.taskTracker.model.Task;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class TaskManagerImpl implements TaskManager {
    private final List<Task> tasks = new ArrayList<>();
    private int idCounter = 1;

    @Override
    public void addTask(String title, String category, String dueDateStr, String priorityStr) {
        LocalDate dueDate = LocalDate.parse(dueDateStr);
        Priority priority = Priority.valueOf(priorityStr.toUpperCase());
        tasks.add(new Task(idCounter++, title, category, dueDate, priority));
    }

    @Override
    public void markTaskCompleted(int id) {
        Task task = findTaskById(id);
        task.markCompleted();
    }

    @Override
    public void deleteTask(int id) {
        if (!tasks.removeIf(t -> t.getId() == id)) {
            throw new TaskNotFoundException(id);
        }
    }

    @Override
    public List<Task> getAllTasks() {
        return tasks;
    }

    @Override
    public List<Task> getCompletedTasks() {
        return tasks.stream().filter(Task::isCompleted).collect(Collectors.toList());
    }

    @Override
    public List<Task> getPendingTasks() {
        return tasks.stream().filter(t -> !t.isCompleted()).collect(Collectors.toList());
    }

    @Override
    public List<Task> getOverdueTasks() {
        return tasks.stream().filter(Task::isOverdue).collect(Collectors.toList());
    }

    @Override
    public List<Task> getTasksSortedByPriority() {
        return tasks.stream()
                .sorted(Comparator.comparing(Task::getPriority).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, List<Task>> getTasksByCategory() {
        return tasks.stream().collect(Collectors.groupingBy(Task::getCategory));
    }

    private Task findTaskById(int id) {
        return tasks.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElseThrow(() -> new TaskNotFoundException(id));
    }
}
