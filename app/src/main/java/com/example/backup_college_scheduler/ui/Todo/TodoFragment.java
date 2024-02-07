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
import com.example.backup_college_scheduler.back.Todo.Todo;
import com.example.backup_college_scheduler.back.Todo.TodoAdapter;
import com.example.backup_college_scheduler.back.Todo.TodoList;

public class TodoFragment extends Fragment {
    private static TodoAdapter itemAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_todo, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TodoList todoList = new TodoList(getContext());
        itemAdapter = new TodoAdapter(todoList);

        // Set the LayoutManager that this RecyclerView will use.
        RecyclerView recyclerView = view.findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        // adapter instance is set to the recyclerview to inflate the items.
        recyclerView.setAdapter(itemAdapter);

        view.findViewById(R.id.sortTodoByClass).setOnClickListener(fragmentView -> {
            if (todoList != null) {
                todoList.sortTodosByClass();
                itemAdapter.notifyDataSetChanged();
            }
        });

        view.findViewById(R.id.sortTodoByDueDate).setOnClickListener(fragmentView -> {
            if (todoList != null) {
                todoList.sortTodosByDueDate();
                itemAdapter.notifyDataSetChanged();
            }
        });

        Button openDialog = view.findViewById(R.id.addTodoButton);
        openDialog.setOnClickListener(view1 -> {
            Dialog dialog = new Dialog(view1.getContext());
            dialog.setCancelable(true);
            dialog.setContentView(R.layout.fragment_add_new_todo);

            EditText nameEt = dialog.findViewById(R.id.newTodoName);
            EditText courseEt = dialog.findViewById(R.id.newTodoCourse);
            EditText dueDateEt = dialog.findViewById(R.id.newTodoDueDate);
            Button submitButton = dialog.findViewById(R.id.newTodoAddButton);

            submitButton.setOnClickListener(v -> {
                String name = nameEt.getText().toString();
                String course = courseEt.getText().toString();
                String dueDate = dueDateEt.getText().toString();
                TodoFragment.itemAdapter.addNewTodo(new Todo(name, course, dueDate));
                dialog.dismiss();
            });

            dialog.show();
        });
    }
}
