package com.example.backup_college_scheduler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {
    public ArrayList<Todo> todoList;

    public TodoAdapter(ArrayList<Todo> todoList) {
        this.todoList = todoList;
    }

    @Override
    public TodoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate the layout for each item and return a new ViewHolder object
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_list, parent, false);
        return new TodoViewHolder(itemView).linkAdapter(this);
    }

    @Override
    public void onBindViewHolder(TodoViewHolder holder, int position) {
        Todo currTodo = todoList.get(position);
        holder.todoName.setText(currTodo.getName());
        holder.todoCourse.setText(currTodo.getCourseName());
        holder.todoDueDate.setText(currTodo.getDueDate());

    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }

    public static class TodoViewHolder extends RecyclerView.ViewHolder {
        private TextView todoName;
        private TextView todoCourse;
        private TextView todoDueDate;

        private TodoAdapter adapter;

        public TodoViewHolder(View itemView) {
            super(itemView);
            todoName = itemView.findViewById(R.id.todoName);
            todoCourse = itemView.findViewById(R.id.todoCourse);
            todoDueDate = itemView.findViewById(R.id.todoDueDate);

            itemView.findViewById(R.id.todoDoneButton).setOnClickListener(view -> {
                if (adapter.todoList != null) {
                    adapter.todoList.remove(getAdapterPosition());
                    adapter.notifyItemRemoved(getAdapterPosition());
                }
            });
        }

        public TodoViewHolder linkAdapter(TodoAdapter adapter) {
            this.adapter = adapter;
            return this;
        }
    }

}
