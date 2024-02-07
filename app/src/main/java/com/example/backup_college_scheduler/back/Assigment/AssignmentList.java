package com.example.backup_college_scheduler.back.Assigment;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;

public class AssignmentList {
    private final static String FILE_NAME = "assignmentData";

    private final Context context;
    private ArrayList<Assignment> assignments;

    public AssignmentList(Context context) {
        this.context = context;
        loadAssignmentData();
    }

    public void loadAssignmentData() {
        File file = new File(context.getFilesDir(), FILE_NAME);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                assignments = (ArrayList<Assignment>) ois.readObject();
            } catch (Exception e) {
                assignments = new ArrayList<>();
                e.printStackTrace();
            }
        } else {
            assignments = new ArrayList<>();
            assignments.add(new Assignment("Exercises 1-3", "MATH2551", "2024:02:09"));
            assignments.add(new Assignment("Read chapters 12-15", "ENGL1102", "2024:02:27"));
            assignments.add(new Assignment("Complete HW02", "CS1332", "2024:03:01"));
            saveAssignmentData();
        }
    }

    public void saveAssignmentData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE))) {
            oos.writeObject(assignments);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Assignment get(int position) {
        return assignments.get(position);
    }

    public int size() {
        return assignments.size();
    }

    public void remove(int adapterPosition) {
        assignments.remove(adapterPosition);
        saveAssignmentData();
    }

    public void add(Assignment c) {
        assignments.add(c);
        saveAssignmentData();
    }

    public void sortAssignmentsByClass() {
        assignments.sort(Comparator.comparing(Assignment::getCourseName));
    }

    public void sortAssignmentsByDueDate() {
        assignments.sort(Comparator.comparing(Assignment::getDueDate));
    }

    public void update(int index, Assignment a) {
        assignments.get(index).update(a);
        saveAssignmentData();
    }
}