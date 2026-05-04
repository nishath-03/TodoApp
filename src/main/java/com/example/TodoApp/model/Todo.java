package com.example.TodoApp.model;

import jakarta.persistence.*;
@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String description;
    private boolean completed;
    private String priority; // LOW, MEDIUM, HIGH

    public Todo(){}
    public Todo(
     String title,
     String description,
     boolean completed){

        this.title = title;
        this.description =description;
        this.completed =completed;

    }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }
}
