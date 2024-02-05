package com.example.backup_college_scheduler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AssignmentAdapter extends RecyclerView.Adapter<AssignmentAdapter.AssignmentViewHolder> {
    private ArrayList<Assignment> assignmentList;

    public AssignmentAdapter(ArrayList<Assignment> assignmentList) {
        this.assignmentList = assignmentList;
    }

    @Override
    public AssignmentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate the layout for each item and return a new ViewHolder object
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.assignment_list, parent, false);
        return new AssignmentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AssignmentViewHolder holder, int position) {
        Assignment currAssignment = assignmentList.get(position);
        holder.assignmentName.setText(currAssignment.getName());
        holder.assignmentCourse.setText(currAssignment.getCourseName());
        holder.assignmentDueDate.setText(currAssignment.getDueDate());
    }

    @Override
    public int getItemCount() {
        return assignmentList.size();
    }

    public static class AssignmentViewHolder extends RecyclerView.ViewHolder {
        private TextView assignmentName;
        private TextView assignmentCourse;
        private TextView assignmentDueDate;

        public AssignmentViewHolder(View itemView) {
            super(itemView);
            assignmentName = itemView.findViewById(R.id.assignmentName);
            assignmentCourse = itemView.findViewById(R.id.assignmentCourse);
            assignmentDueDate = itemView.findViewById(R.id.assignmentDueDate);
        }
    }

}
