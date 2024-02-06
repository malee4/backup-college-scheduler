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

import com.example.backup_college_scheduler.back.Course.Course;
import com.example.backup_college_scheduler.back.Course.CourseAdapter;
import com.example.backup_college_scheduler.back.Exam.Exam;
import com.example.backup_college_scheduler.back.Exam.ExamAdapter;
import com.example.backup_college_scheduler.back.Exam.ExamList;
import com.example.backup_college_scheduler.R;
import com.example.backup_college_scheduler.ui.CourseUI.CourseFragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ExamFragment extends Fragment {
    private String param1;
    private String param2;

    public static ExamAdapter itemAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            param1 = getArguments().getString("param1");
            param2 = getArguments().getString("param2");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exams,
                container, false);
    }

    @Override
    public void
    onViewCreated(@NonNull View view,
                  @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<Exam> examList
                = ExamList.getExamData();
        this.itemAdapter = new ExamAdapter(examList);
        // Set the LayoutManager that
        // this RecyclerView will use.
        RecyclerView recyclerView
                = view.findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(getContext()));
        // adapter instance is set to the
        // recyclerview to inflate the items.
        recyclerView.setAdapter(itemAdapter);

        view.findViewById(R.id.sortExamByClass).setOnClickListener(fragmentView -> {
            if (examList != null) {
                Collections.sort(examList, new Comparator<Exam>() {
                    @Override
                    public int compare(Exam a, Exam b) {
                        return a.getCourseName().compareTo(b.getCourseName());
                    }
                });
                itemAdapter.notifyDataSetChanged();
            }
        });

        view.findViewById(R.id.sortExamByDueDate).setOnClickListener(fragmentView -> {
            if (examList != null) {
                Collections.sort(examList, new Comparator<Exam>() {
                    @Override
                    public int compare(Exam a, Exam b) {
                        return a.getTime().compareTo(b.getTime());
                    }
                });
                itemAdapter.notifyDataSetChanged();
            }
        });

        Button openDialog = view.findViewById(R.id.addExamButton);
        openDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(view.getContext());
                dialog.setCancelable(true);
                dialog.setContentView(R.layout.fragment_add_new_exam);

                EditText nameEt = dialog.findViewById(R.id.newExamName);
                EditText descriptionEt = dialog.findViewById(R.id.newExamDescription);
                EditText courseEt = dialog.findViewById(R.id.newExamCourse);
                EditText locationEt = dialog.findViewById(R.id.newExamLocation);
                EditText timeEt = dialog.findViewById(R.id.newExamTime);
                Button submitButton = dialog.findViewById(R.id.newExamAddButton);

                submitButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = nameEt.getText().toString();
                        String description = descriptionEt.getText().toString();
                        String course = courseEt.getText().toString();
                        String location = locationEt.getText().toString();
                        String time = timeEt.getText().toString();
                        ExamFragment.itemAdapter.addNewExam(new Exam(name, description, course, location, time));
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });
    }


    public static ExamFragment newInstance(String param1,
                                           String param2)
    {
        ExamFragment fragment = new ExamFragment();
        Bundle args = new Bundle();
        args.putString("param1", param1);
        args.putString("param2", param2);
        fragment.setArguments(args);
        return fragment;
    }
}