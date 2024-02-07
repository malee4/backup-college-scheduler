package com.example.backup_college_scheduler.ui.ExamUI;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.backup_college_scheduler.R;
import com.example.backup_college_scheduler.back.Exam.Exam;
import com.example.backup_college_scheduler.back.Exam.ExamAdapter;
import com.example.backup_college_scheduler.back.Exam.ExamList;

public class ExamFragment extends Fragment {
    private static ExamAdapter itemAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exams, container, false);
    }

    @Override
    public void
    onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ExamList examList = new ExamList(getContext());
        itemAdapter = new ExamAdapter(examList);

        // Set the LayoutManager that this RecyclerView will use.
        RecyclerView recyclerView = view.findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // adapter instance is set to the recyclerview to inflate the items.
        recyclerView.setAdapter(itemAdapter);

        view.findViewById(R.id.sortExamByClass).setOnClickListener(fragmentView -> {
            if (examList != null) {
                examList.sortByClass();
                itemAdapter.notifyDataSetChanged();
            }
        });

        view.findViewById(R.id.sortExamByDueDate).setOnClickListener(fragmentView -> {
            if (examList != null) {
                examList.sortByDueDate();
                itemAdapter.notifyDataSetChanged();
            }
        });

        Button openDialog = view.findViewById(R.id.addExamButton);
        openDialog.setOnClickListener(view1 -> {
            Dialog dialog = new Dialog(view1.getContext());
            dialog.setCancelable(true);
            dialog.setContentView(R.layout.fragment_add_new_exam);

            EditText nameEt = dialog.findViewById(R.id.newExamName);
            EditText descriptionEt = dialog.findViewById(R.id.newExamDescription);
            EditText courseEt = dialog.findViewById(R.id.newExamCourse);
            EditText locationEt = dialog.findViewById(R.id.newExamLocation);
            EditText timeEt = dialog.findViewById(R.id.newExamTime);
            Button submitButton = dialog.findViewById(R.id.newExamAddButton);

            submitButton.setOnClickListener(v -> {
                String name = nameEt.getText().toString();
                String description = descriptionEt.getText().toString();
                String course = courseEt.getText().toString();
                String location = locationEt.getText().toString();
                String time = timeEt.getText().toString();
                ExamFragment.itemAdapter.addNewExam(new Exam(name, description, course, location, time));
                dialog.dismiss();
            });

            dialog.show();
        });
    }
}