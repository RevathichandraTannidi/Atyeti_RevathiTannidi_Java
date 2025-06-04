package com.atyeti.project.taskTracker.service;

import com.atyeti.project.taskTracker.model.Task;

import java.util.List;
import java.util.Map;

public interface TaskManager {
    void addTask(String title, String category, String dueDateStr, String priorityStr);
    void markTaskCompleted(int id);
    void deleteTask(int id);
    List<Task> getAllTasks();
    List<Task> getCompletedTasks();
    List<Task> getPendingTasks();
    List<Task> getOverdueTasks();
    List<Task> getTasksSortedByPriority();
    Map<String, List<Task>> getTasksByCategory();
}
