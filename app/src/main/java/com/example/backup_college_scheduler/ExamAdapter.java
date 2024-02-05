package com.example.backup_college_scheduler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExamAdapter extends RecyclerView.Adapter<ExamAdapter.ExamViewHolder> {
    private ArrayList<Exam> examList;

    public ExamAdapter(ArrayList<Exam> examList) {
        this.examList = examList;
    }

    @Override
    public ExamAdapter.ExamViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate the layout for each item and return a new ViewHolder object
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.exam_list, parent, false);
        return new ExamViewHolder(itemView).linkAdapter(this);
    }

    @Override
    public void onBindViewHolder(ExamAdapter.ExamViewHolder holder, int position) {
        Exam currExam = examList.get(position);
        holder.examName.setText(currExam.getName());
        holder.examCourseName.setText(currExam.getCourseName());
        holder.examLocation.setText(currExam.getLocation());
        holder.examTime.setText(currExam.getTime());
    }

    @Override
    public int getItemCount() {
        return examList.size();
    }

    public static class ExamViewHolder extends RecyclerView.ViewHolder {
        private TextView examName;
        private TextView examCourseName;
        private TextView examLocation;
        private TextView examTime;

        private ExamAdapter adapter;


        public ExamViewHolder(View itemView) {
            super(itemView);
            examName = itemView.findViewById(R.id.examName);
            examCourseName = itemView.findViewById(R.id.examCourseName);
            examLocation = itemView.findViewById(R.id.examLocation);
            examTime = itemView.findViewById(R.id.examTime);
        }

        public ExamAdapter.ExamViewHolder linkAdapter(ExamAdapter adapter) {
            this.adapter = adapter;
            return this;
        }
    }
}
