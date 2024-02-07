package com.example.backup_college_scheduler.back.Todo;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;

public class TodoList {
    private final static String FILE_NAME = "todoData";

    private final Context context;
    private ArrayList<Todo> todos;

    public TodoList(Context context) {
        this.context = context;
        loadTodoData();
    }

    public void loadTodoData() {
        File file = new File(context.getFilesDir(), FILE_NAME);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                todos = (ArrayList<Todo>) ois.readObject();
            } catch (Exception e) {
                todos = new ArrayList<>();
                e.printStackTrace();
            }
        } else {
            todos = new ArrayList<>();
            todos.add(new Todo("Rework recitation problems", "MATH2106", "2024:02:03"));
            todos.add(new Todo("Book CS2340 meeting room", "CS2340", "2024:02:01"));
            todos.add(new Todo("Email Dr. Shepler", "CHEM1212K", "2024:02:09"));
            saveTodoData();
        }
    }

    public void saveTodoData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE))) {
            oos.writeObject(todos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Todo get(int position) {
        return todos.get(position);
    }

    public int size() {
        return todos.size();
    }

    public void remove(int adapterPosition) {
        todos.remove(adapterPosition);
        saveTodoData();
    }

    public void add(Todo c) {
        todos.add(c);
        saveTodoData();
    }

    public void sortTodosByClass() {
        todos.sort(Comparator.comparing(Todo::getCourseName));
    }

    public void sortTodosByDueDate() {
        todos.sort(Comparator.comparing(Todo::getDueDate));
    }

    public void update(int index, Todo t) {
        todos.get(index).update(t);
        saveTodoData();
    }
}
