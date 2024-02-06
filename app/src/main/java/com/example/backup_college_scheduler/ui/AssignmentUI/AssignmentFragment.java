package com.example.backup_college_scheduler.ui.AssignmentUI;

import android.app.AlertDialog;
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

import com.example.backup_college_scheduler.MainActivity;
import com.example.backup_college_scheduler.back.Assigment.Assignment;
import com.example.backup_college_scheduler.back.Assigment.AssignmentAdapter;
import com.example.backup_college_scheduler.back.Assigment.AssignmentList;
import com.example.backup_college_scheduler.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AssignmentFragment extends Fragment {
    private String param1;
    private String param2;

    public static AssignmentAdapter itemAdapter;

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
        return inflater.inflate(R.layout.fragment_assignments,
                container, false);
    }

    @Override
    public void
    onViewCreated(@NonNull View view,
                  @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<Assignment> assignmentList
                = AssignmentList.getAssignmentData();
        itemAdapter = new AssignmentAdapter(assignmentList);
        // Set the LayoutManager that
        // this RecyclerView will use.
        RecyclerView recyclerView
                = view.findViewById(R.id.recycleView);
//        recyclerView.setLayoutManager(
//                new LinearLayoutManager(getContext()));
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        // adapter instance is set to the
        // recyclerview to inflate the items.
        recyclerView.setAdapter(itemAdapter);

        view.findViewById(R.id.sortAssignmentByClass).setOnClickListener(fragmentView -> {
            if (assignmentList != null) {
                Collections.sort(assignmentList, new Comparator<Assignment>() {
                    @Override
                    public int compare(Assignment a, Assignment b) {
                        return a.getCourseName().compareTo(b.getCourseName());
                    }
                });
                itemAdapter.notifyDataSetChanged();
            }
        });

        view.findViewById(R.id.sortAssignmentByDueDate).setOnClickListener(fragmentView -> {
            if (assignmentList != null) {
                Collections.sort(assignmentList, new Comparator<Assignment>() {
                    @Override
                    public int compare(Assignment a, Assignment b) {
                        return a.getDueDate().compareTo(b.getDueDate());
                    }
                });
            }
        });

        Button openDialog = view.findViewById(R.id.addAssignmentButton);
        openDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(view.getContext());
                dialog.setCancelable(true);
                dialog.setContentView(R.layout.fragment_add_new_assignment);

                EditText nameEt = dialog.findViewById(R.id.newAssignmentName);
                EditText courseEt = dialog.findViewById(R.id.newAssignmentCourse);
                EditText dueDateEt = dialog.findViewById(R.id.newAssignmentDueDate);
                Button submitButton = dialog.findViewById(R.id.newAssignmentAddButton);

                submitButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = nameEt.getText().toString();
                        String course = courseEt.getText().toString();
                        String dueDate = dueDateEt.getText().toString();
                        AssignmentFragment.itemAdapter.addNewAssignment(new Assignment(name, course, dueDate));
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });
    }



    public static AssignmentFragment newInstance(String param1,
                                                 String param2)
    {
        AssignmentFragment fragment = new AssignmentFragment();
        Bundle args = new Bundle();
        args.putString("param1", param1);
        args.putString("param2", param2);
        fragment.setArguments(args);
        return fragment;
    }
}