package com.example.backup_college_scheduler.back.Exam;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;

public class ExamList {
    private final static String FILE_NAME = "examData";

    private final Context context;
    private ArrayList<Exam> exams;

    public ExamList(Context context) {
        this.context = context;
        loadExamData();
    }

    public void loadExamData() {
        File file = new File(context.getFilesDir(), FILE_NAME);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                exams = (ArrayList<Exam>) ois.readObject();
            } catch (Exception e) {
                exams = new ArrayList<>();
                e.printStackTrace();
            }
        } else {
            exams = new ArrayList<>();
            exams.add(new Exam("Midterm 1", "ADTs", "CS1332", "CULC 154", "2024:02:08 3:30pm-4:20pm"));
            exams.add(new Exam("Assessment 1", "Code Smells", "CS2340", "HOWEY 100", "2024:02:03 8:00am-9:15am"));
            saveExamData();
        }
    }

    public void saveExamData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE))) {
            oos.writeObject(exams);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Exam get(int index) {
        return exams.get(index);
    }

    public int size() {
        return exams.size();
    }

    public void sortByClass() {
        exams.sort(Comparator.comparing(Exam::getCourseName));
    }

    public void sortByDueDate() {
        exams.sort(Comparator.comparing(Exam::getTime));
    }

    public void remove(int index) {
        exams.remove(index);
        saveExamData();
    }

    public void add(Exam exam) {
        exams.add(exam);
        saveExamData();
    }

    public void update(int index, Exam exam) {
        exams.get(index).update(exam);
        saveExamData();
    }
}
