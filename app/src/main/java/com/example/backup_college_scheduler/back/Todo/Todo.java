package com.example.backup_college_scheduler.back.Todo;

import java.io.Serializable;

public class Todo implements Serializable {
    private String name;
    private String courseName;
    private String dueDate;

    public Todo() {
        this.name = "";
        this.courseName = "";
        this.dueDate = null;
    }

    public Todo(String name, String courseName, String dueDate) {
        this.name = name;
        this.courseName = courseName;
        this.dueDate = dueDate;
    }

    public void update(Todo todo) {
        if (!todo.getName().isEmpty()) {
            this.name = todo.getName();
        }
        if (!todo.getCourseName().isEmpty()) {
            this.courseName = todo.getCourseName();
        }
        if (!todo.getDueDate().isEmpty()) {
            this.dueDate = todo.getDueDate();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
