package com.example.backup_college_scheduler.back.Assigment;

import java.util.Date;
import java.io.Serializable;

public class Assignment implements Serializable {

    public String name;

    public String courseName;

    public String dueDate;

    public boolean done;

    public Assignment() {
        this.name = "";
        this.courseName = "";
        this.dueDate = null;
        this.done = false;
    }

    public Assignment(String name,
                      String courseName,
                      String dueDate) {
        this.name = name;
        this.courseName = courseName;
        this.dueDate = dueDate;
        this.done = false;
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

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
