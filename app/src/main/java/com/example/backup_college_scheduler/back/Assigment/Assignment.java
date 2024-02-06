package com.example.backup_college_scheduler.back.Assigment;

import com.example.backup_college_scheduler.back.Todo.Todo;

import java.util.Date;
import java.io.Serializable;

public class Assignment implements Serializable {

    public String name;

    public String courseName;

    public String dueDate;

    public Assignment() {
        this.name = "";
        this.courseName = "";
        this.dueDate = null;
    }

    public Assignment(String name,
                      String courseName,
                      String dueDate) {
        this.name = name;
        this.courseName = courseName;
        this.dueDate = dueDate;
    }

    public void update(Assignment t) {
        if (!t.name.equals("")) {
            this.name = t.name;
        }
        if (!t.courseName.equals("")) {
            this.courseName = t.courseName;
        }
        if (!t.dueDate.equals("")) {
            this.dueDate = t.dueDate;
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
