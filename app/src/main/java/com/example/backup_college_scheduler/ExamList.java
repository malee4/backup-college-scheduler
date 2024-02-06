package com.example.backup_college_scheduler;

import java.util.ArrayList;

public class ExamList {
    private static ArrayList<Exam> list = new ArrayList<>();

    public static ArrayList<Exam> getExamData() {
        list.clear();
        list.add(new Exam("Midterm 1", "ADTs", "CS1332", "CULC 154", "2024:02:08 3:30pm-4:20pm"));
        list.add(new Exam("Assessment 1", "Code Smells", "CS2340", "HOWEY 100", "2024:02:03 8:00am-9:15am"));
        return list;
    }
}
