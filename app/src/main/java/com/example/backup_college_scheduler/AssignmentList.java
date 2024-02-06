package com.example.backup_college_scheduler;

import java.util.ArrayList;

public class AssignmentList {
    /**
     *     public String name;
     *
     *     public String courseName;
     *
     *     public String dueDate;
     *
     *     public boolean done;
     */

    private static ArrayList<Assignment> list = new ArrayList<>();

    public static ArrayList<Assignment> getAssignmentData() {
        list.clear();
        list.add(new Assignment("Exercises 1-3", "MATH2551", "2024:02:09"));
        list.add(new Assignment("Read chapters 12-15", "ENGL1102", "2024:02:27"));
        list.add(new Assignment("Complete HW02", "CS1332", "2024:03:01"));
        return list;
    }

}
