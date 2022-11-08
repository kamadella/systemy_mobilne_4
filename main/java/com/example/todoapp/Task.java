package com.example.todoapp;

import java.util.Date;
import java.util.UUID;
import lombok.Data;

@Data
public class Task {
    private UUID id;
    private String name;
    private Date date;
    private boolean done;

    public Task() {
        id = UUID.randomUUID();
        date = new Date();
    }
}
