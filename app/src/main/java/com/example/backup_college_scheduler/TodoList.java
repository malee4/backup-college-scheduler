package com.example.backup_college_scheduler;

import java.util.ArrayList;

public class TodoList {

    private static ArrayList<Todo> list = new ArrayList<>();

    public static ArrayList<Todo> getTodoData() {
        list.clear();
        list.add(new Todo("Email Dr. Shepler", "CHEM1212K", "2024:02:09"));
        list.add(new Todo("Book CS2340 meeting room", "CS2340", "2024:02:01"));
        list.add(new Todo("Rework recitation problems", "MATH2106", "2024:02:03"));
        return list;
    }
}
