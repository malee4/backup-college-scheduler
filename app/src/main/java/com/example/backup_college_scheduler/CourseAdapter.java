package com.example.backup_college_scheduler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {
    private ArrayList<Course> courseList;

    public CourseAdapter(ArrayList<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public CourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate the layout for each item and return a new ViewHolder object
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_list, parent, false);
        return new CourseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CourseViewHolder holder, int position) {
        Course currCourse = courseList.get(position);
        holder.courseName.setText(currCourse.getName());
        holder.instructor.setText(currCourse.getInstructor());
        holder.courseDescription.setText(currCourse.getDescription());
        holder.courseTime.setText(currCourse.getCourseTime());
    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    public static class CourseViewHolder extends RecyclerView.ViewHolder {
        private TextView courseName;
        private TextView instructor;
        private TextView courseDescription;
        private TextView courseTime;


        public CourseViewHolder(View itemView) {
            super(itemView);
            courseName = itemView.findViewById(R.id.courseName);
            instructor = itemView.findViewById(R.id.instructor);
            courseDescription = itemView.findViewById(R.id.courseDescription);
            courseTime = itemView.findViewById(R.id.courseTime);
        }
    }

}