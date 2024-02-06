package com.example.backup_college_scheduler.back.Exam;

import java.io.Serializable;

public class Exam implements Serializable {
    private String name;

    private String description;

    private String courseName;

    private String location;

    private String time;

    public Exam() {
        this.name = "";
        this.description = "";
        this.courseName = "";
        this.location = "";
        this.time = "";
    }

    public Exam(String name,
                String description,
                String courseName,
                String location,
                String time) {
        this.name = name;
        this.description = description;
        this.courseName = courseName;
        this.location = location;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
