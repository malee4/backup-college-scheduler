package com.example.backup_college_scheduler;

import java.util.ArrayList;

//private String name;
//private String description;
//private String instructor;
//private String courseTime;

public class CourseList {

    private static ArrayList<Course> list = new ArrayList<>();

    public static ArrayList<Course> getCourseData() {
        list.add(new Course("CS1332", "Data structures & algorithms", "Faulkner", "MWF 3:30pm-4:20pm"));
        list.add(new Course("MATH2106", "Foundations of math proofs", "Shahaf", "TTh 12:30pm-1:20pm"));
        list.add(new Course("CS2340", "Objects & design", "Pedro", "MW 8:00am-9:15am"));
        return list;
    }
}
