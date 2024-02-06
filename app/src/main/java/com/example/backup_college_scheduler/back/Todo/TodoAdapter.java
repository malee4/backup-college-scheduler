package com.example.backup_college_scheduler.back.Todo;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.backup_college_scheduler.R;
import com.example.backup_college_scheduler.back.Exam.Exam;

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

            itemView.findViewById(R.id.editTodoButton).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Dialog dialog = new Dialog(view.getContext());
                    dialog.setCancelable(true);
                    dialog.setContentView(R.layout.fragment_edit_todo);

                    EditText nameEt = dialog.findViewById(R.id.updateTodoName);
                    EditText courseEt = dialog.findViewById(R.id.updateTodoCourse);
                    EditText dueDateEt = dialog.findViewById(R.id.updateTodoDueDate);
                    Button submitButton = dialog.findViewById(R.id.updateTodoButton);

                    submitButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String name = nameEt.getText().toString();
                            String course = courseEt.getText().toString();
                            String dueDate = dueDateEt.getText().toString();
                            Todo task = adapter.todoList.get(getAdapterPosition());
                            task.update(new Todo(name, course, dueDate));
                            adapter.notifyItemChanged(getAdapterPosition());
                            dialog.dismiss();
                        }
                    });

                    dialog.show();
                }
            });
        }

        public TodoViewHolder linkAdapter(TodoAdapter adapter) {
            this.adapter = adapter;
            return this;
        }
    }

    public void addNewTodo(Todo t) {
        this.todoList.add(t);
        this.notifyItemInserted(todoList.size());
    }

}
