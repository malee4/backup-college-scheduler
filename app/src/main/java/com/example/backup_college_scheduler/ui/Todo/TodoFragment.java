package com.example.backup_college_scheduler.ui.Todo;

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
import com.example.backup_college_scheduler.back.Todo.Todo;
import com.example.backup_college_scheduler.back.Todo.TodoAdapter;
import com.example.backup_college_scheduler.back.Todo.TodoList;
import com.example.backup_college_scheduler.ui.AssignmentUI.AssignmentFragment;
import com.example.backup_college_scheduler.ui.ExamUI.ExamFragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TodoFragment extends Fragment {

    private String param1;
    private String param2;

    public static TodoAdapter itemAdapter;
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
        this.itemAdapter = new TodoAdapter(todoList);
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

        Button openDialog = view.findViewById(R.id.addTodoButton);
        openDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(view.getContext());
                dialog.setCancelable(true);
                dialog.setContentView(R.layout.fragment_add_new_todo);

                EditText nameEt = dialog.findViewById(R.id.newTodoName);
                EditText courseEt = dialog.findViewById(R.id.newTodoCourse);
                EditText dueDateEt = dialog.findViewById(R.id.newTodoDueDate);
                Button submitButton = dialog.findViewById(R.id.newTodoAddButton);

                submitButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = nameEt.getText().toString();
                        String course = courseEt.getText().toString();
                        String dueDate = dueDateEt.getText().toString();
                        TodoFragment.itemAdapter.addNewTodo(new Todo(name, course, dueDate));
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
