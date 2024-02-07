package com.example.backup_college_scheduler.back.Assigment;

import java.io.Serializable;

public class Assignment implements Serializable {
    private String name;
    private String courseName;
    private String dueDate;

    public Assignment() {
        this.name = "";
        this.courseName = "";
        this.dueDate = null;
    }

    public Assignment(String name, String courseName, String dueDate) {
        this.name = name;
        this.courseName = courseName;
        this.dueDate = dueDate;
    }

    public void update(Assignment assignment) {
        if (!assignment.getName().isEmpty()) {
            this.name = assignment.getName();
        }
        if (!assignment.getCourseName().isEmpty()) {
            this.courseName = assignment.getCourseName();
        }
        if (!assignment.getDueDate().isEmpty()) {
            this.dueDate = assignment.getDueDate();
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
