package com.example.backup_college_scheduler.ui;

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
import com.example.backup_college_scheduler.AssignmentAdapter;
import com.example.backup_college_scheduler.AssignmentList;
import com.example.backup_college_scheduler.Exam;
import com.example.backup_college_scheduler.R;
import com.example.backup_college_scheduler.Todo;
import com.example.backup_college_scheduler.TodoAdapter;
import com.example.backup_college_scheduler.TodoList;
import com.example.backup_college_scheduler.ui.AssignmentUI.DashboardFragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TodoFragment extends Fragment {

    private String param1;
    private String param2;

    //    private FragmentDashboardBinding binding;
    //    ArrayList<Assignment> assignmentArrayList = new ArrayList<>();
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
        return inflater.inflate(R.layout.fragment_todo,
                container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view,
                  @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<Todo> todoList
                = TodoList.getTodoData();
        TodoAdapter itemAdapter = new TodoAdapter(todoList);
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

        view.findViewById(R.id.sortTodoByClass).setOnClickListener(fragmentView -> {
            if (todoList != null) {
                Collections.sort(todoList, new Comparator<Todo>() {
                    @Override
                    public int compare(Todo a, Todo b) {
                        return a.getCourseName().compareTo(b.getCourseName());
                    }
                });
                itemAdapter.notifyDataSetChanged();
            }
        });

        view.findViewById(R.id.sortTodoByDueDate).setOnClickListener(fragmentView -> {
            if (todoList != null) {
                Collections.sort(todoList, new Comparator<Todo>() {
                    @Override
                    public int compare(Todo a, Todo b) {
                        return a.getDueDate().compareTo(b.getDueDate());
                    }
                });
                itemAdapter.notifyDataSetChanged();
            }
        });
    }


    public static DashboardFragment newInstance(String param1,
                                                String param2)
    {
        DashboardFragment fragment = new DashboardFragment();
        Bundle args = new Bundle();
        args.putString("param1", param1);
        args.putString("param2", param2);
        fragment.setArguments(args);
        return fragment;
    }
}
