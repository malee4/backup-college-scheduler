package com.example.backup_college_scheduler.back.Course;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class CourseList {
    private final static String FILE_NAME = "courseData";

    private final Context context;
    private ArrayList<Course> courses;

    public CourseList(Context context) {
        this.context = context;
        loadCourseData();
    }

    public void loadCourseData() {
        File file = new File(context.getFilesDir(), FILE_NAME);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                courses = (ArrayList<Course>) ois.readObject();
            } catch (Exception e) {
                courses = new ArrayList<>();
                e.printStackTrace();
            }
        } else {
            courses = new ArrayList<>();
            courses.add(new Course("CS1332", "Data structures & algorithms", "Faulkner", "MWF 3:30pm-4:20pm"));
            courses.add(new Course("MATH2106", "Foundations of math proofs", "Shahaf", "TTh 12:30pm-1:20pm"));
            courses.add(new Course("CS2340", "Objects & design", "Pedro", "MW 8:00am-9:15am"));
            saveCourseData();
        }
    }

    public void saveCourseData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE))) {
            oos.writeObject(courses);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Course get(int position) {
        return courses.get(position);
    }

    public int size() {
        return courses.size();
    }

    public void remove(int index) {
        courses.remove(index);
        saveCourseData();
    }

    public void add(Course c) {
        courses.add(c);
        saveCourseData();
    }

    public void update(int index, Course c) {
        courses.get(index).update(c);
        saveCourseData();
    }
}
