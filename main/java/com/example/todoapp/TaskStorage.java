package com.example.todoapp;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TaskStorage {
    private static TaskStorage instance;
    private static List<Task> tasks;

    @RequiresApi(api = Build.VERSION_CODES.N)
    private TaskStorage() {
        tasks = generateTasks();

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private List<Task> generateTasks(){
        return IntStream.of(100)
                .mapToObj(number -> {
                    Task task = new Task();
                    task.setName("Task: " + number);
                    if(number % 3 != 0 ){
                        task.setDone(true);
                    }
                    return task;
                }).collect(Collectors.toList());
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static TaskStorage getInstance() {
        if (instance == null) {
            instance = new TaskStorage();
        }
        return instance;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Optional<Task> getTask(UUID id) {
        return tasks.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst();
    }
}
