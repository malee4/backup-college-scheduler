package com.example.backup_college_scheduler.back.Exam;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.backup_college_scheduler.R;
import com.example.backup_college_scheduler.back.Assigment.Assignment;
import com.example.backup_college_scheduler.back.Todo.Todo;

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
        holder.examDescription.setText(currExam.getDescription());
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
        private TextView examDescription;
        private TextView examCourseName;
        private TextView examLocation;
        private TextView examTime;

        private ExamAdapter adapter;


        public ExamViewHolder(View itemView) {
            super(itemView);
            examName = itemView.findViewById(R.id.examName);
            examDescription = itemView.findViewById(R.id.examDescription);
            examCourseName = itemView.findViewById(R.id.examCourseName);
            examLocation = itemView.findViewById(R.id.examLocation);
            examTime = itemView.findViewById(R.id.examTime);

            itemView.findViewById(R.id.deleteExamButton).setOnClickListener(view -> {
                if (adapter.examList != null) {
                    adapter.examList.remove(getAdapterPosition());
                    adapter.notifyItemRemoved(getAdapterPosition());
                }
            });

            itemView.findViewById(R.id.editExamButton).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Dialog dialog = new Dialog(view.getContext());
                    dialog.setCancelable(true);
                    dialog.setContentView(R.layout.fragment_edit_exam);

                    EditText nameEt = dialog.findViewById(R.id.updateExamName);
                    EditText descriptionEt = dialog.findViewById(R.id.updateExamDescription);
                    EditText courseEt = dialog.findViewById(R.id.updateExamCourse);
                    EditText locationEt = dialog.findViewById(R.id.updateExamLocation);
                    EditText timeEt = dialog.findViewById(R.id.updateExamDate);
                    Button submitButton = dialog.findViewById(R.id.updateExamButton);

                    submitButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String name = nameEt.getText().toString();
                            String description = descriptionEt.getText().toString();
                            String course = courseEt.getText().toString();
                            String location = locationEt.getText().toString();
                            String time = timeEt.getText().toString();
                            Exam exam = adapter.examList.get(getAdapterPosition());
                            exam.update(new Exam(name, description, course, location, time));
                            adapter.notifyItemChanged(getAdapterPosition());
                            dialog.dismiss();
                        }
                    });

                    dialog.show();
                }
            });
        }

        public ExamAdapter.ExamViewHolder linkAdapter(ExamAdapter adapter) {
            this.adapter = adapter;
            return this;
        }
    }

    public void addNewExam(Exam e) {
        this.examList.add(e);
        this.notifyItemInserted(examList.size());
    }
}
