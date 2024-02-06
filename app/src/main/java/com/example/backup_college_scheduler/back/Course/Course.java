package com.example.backup_college_scheduler.back.Course;

import java.io.Serializable;

public class Course implements Serializable {
    private String name;

    private String description;

    private String instructor;
    private String courseTime;

    public Course() {
        this.name = "";
        this.description = "";
        this.instructor = "";
        this.courseTime = "";
    }

    public Course(String name,
                  String description,
                  String instructor,
                  String courseTime) {
        this.name = name;
        this.description = description;
        this.instructor = instructor;
        this.courseTime = courseTime;
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

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }
}
