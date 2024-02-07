package com.example.backup_college_scheduler.ui.AssignmentUI;

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
import com.example.backup_college_scheduler.back.Assigment.Assignment;
import com.example.backup_college_scheduler.back.Assigment.AssignmentAdapter;
import com.example.backup_college_scheduler.back.Assigment.AssignmentList;

public class AssignmentFragment extends Fragment {
    private static AssignmentAdapter itemAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_assignments, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        AssignmentList assignmentList = new AssignmentList(getContext());
        itemAdapter = new AssignmentAdapter(assignmentList);

        // Set the LayoutManager that this RecyclerView will use.
        RecyclerView recyclerView = view.findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        // adapter instance is set to the recyclerview to inflate the items.
        recyclerView.setAdapter(itemAdapter);

        view.findViewById(R.id.sortAssignmentByClass).setOnClickListener(fragmentView -> {
            if (assignmentList != null) {
                assignmentList.sortAssignmentsByClass();
                itemAdapter.notifyDataSetChanged();
            }
        });

        view.findViewById(R.id.sortAssignmentByDueDate).setOnClickListener(fragmentView -> {
            if (assignmentList != null) {
                assignmentList.sortAssignmentsByDueDate();
                itemAdapter.notifyDataSetChanged();
            }
        });

        Button openDialog = view.findViewById(R.id.addAssignmentButton);
        openDialog.setOnClickListener(view1 -> {
            Dialog dialog = new Dialog(view1.getContext());
            dialog.setCancelable(true);
            dialog.setContentView(R.layout.fragment_add_new_assignment);

            EditText nameEt = dialog.findViewById(R.id.newAssignmentName);
            EditText courseEt = dialog.findViewById(R.id.newAssignmentCourse);
            EditText dueDateEt = dialog.findViewById(R.id.newAssignmentDueDate);
            Button submitButton = dialog.findViewById(R.id.newAssignmentAddButton);

            submitButton.setOnClickListener(v -> {
                String name = nameEt.getText().toString();
                String course = courseEt.getText().toString();
                String dueDate = dueDateEt.getText().toString();
                AssignmentFragment.itemAdapter.addNewAssignment(new Assignment(name, course, dueDate));
                dialog.dismiss();
            });

            dialog.show();
        });
    }
}