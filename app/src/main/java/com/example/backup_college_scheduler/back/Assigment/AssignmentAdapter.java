package com.example.backup_college_scheduler.back.Assigment;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.backup_college_scheduler.R;

public class AssignmentAdapter extends RecyclerView.Adapter<AssignmentAdapter.AssignmentViewHolder> {
    private AssignmentList assignmentList;

    public AssignmentAdapter(AssignmentList assignmentList) {
        this.assignmentList = assignmentList;
    }

    @Override
    public AssignmentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate the layout for each item and return a new ViewHolder object
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.assignment_list, parent, false);

        return new AssignmentViewHolder(itemView).linkAdapter(this);
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

    public void addNewAssignment(Assignment a) {
        this.assignmentList.add(a);
        this.notifyItemInserted(assignmentList.size());
    }

    public static class AssignmentViewHolder extends RecyclerView.ViewHolder {
        private TextView assignmentName;
        private TextView assignmentCourse;
        private TextView assignmentDueDate;

        private AssignmentAdapter adapter;

        public AssignmentViewHolder(View itemView) {
            super(itemView);
            assignmentName = itemView.findViewById(R.id.assignmentName);
            assignmentCourse = itemView.findViewById(R.id.assignmentCourse);
            assignmentDueDate = itemView.findViewById(R.id.assignmentDueDate);

            itemView.findViewById(R.id.assignmentDoneButton).setOnClickListener(view -> {
                if (adapter.assignmentList != null) {
                    adapter.assignmentList.remove(getAdapterPosition());
                    adapter.notifyItemRemoved(getAdapterPosition());
                }
            });

            itemView.findViewById(R.id.editAssignmentButton).setOnClickListener(view -> {
                Dialog dialog = new Dialog(view.getContext());
                dialog.setCancelable(true);
                dialog.setContentView(R.layout.fragment_edit_assignment);

                EditText nameEt = dialog.findViewById(R.id.updateAssignmentName);
                EditText courseEt = dialog.findViewById(R.id.updateAssignmentCourse);
                EditText dueDateEt = dialog.findViewById(R.id.updateAssignmentDueDate);
                Button submitButton = dialog.findViewById(R.id.updateAssignmentButton);

                submitButton.setOnClickListener(v -> {
                    String name = nameEt.getText().toString();
                    String course = courseEt.getText().toString();
                    String dueDate = dueDateEt.getText().toString();
                    adapter.assignmentList.update(getAdapterPosition(), new Assignment(name, course, dueDate));
                    adapter.notifyItemChanged(getAdapterPosition());
                    dialog.dismiss();
                });

                dialog.show();
            });
        }

        public AssignmentViewHolder linkAdapter(AssignmentAdapter adapter) {
            this.adapter = adapter;
            return this;
        }
    }
}
