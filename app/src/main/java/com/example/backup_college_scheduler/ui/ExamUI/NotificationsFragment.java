package com.example.backup_college_scheduler.ui.ExamUI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.backup_college_scheduler.Assignment;
import com.example.backup_college_scheduler.Exam;
import com.example.backup_college_scheduler.ExamAdapter;
import com.example.backup_college_scheduler.ExamList;
import com.example.backup_college_scheduler.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class NotificationsFragment extends Fragment {
    private String param1;
    private String param2;
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
        ExamAdapter itemAdapter = new ExamAdapter(examList);
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
    }


    public static NotificationsFragment newInstance(String param1,
                                           String param2)
    {
        NotificationsFragment fragment = new NotificationsFragment();
        Bundle args = new Bundle();
        args.putString("param1", param1);
        args.putString("param2", param2);
        fragment.setArguments(args);
        return fragment;
    }
}