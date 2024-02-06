package com.example.backup_college_scheduler.ui.CourseUI;

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

import com.example.backup_college_scheduler.back.Assigment.Assignment;
import com.example.backup_college_scheduler.back.Assigment.AssignmentAdapter;
import com.example.backup_college_scheduler.back.Course.Course;
import com.example.backup_college_scheduler.back.Course.CourseAdapter;
import com.example.backup_college_scheduler.back.Course.CourseList;
import com.example.backup_college_scheduler.R;
import com.example.backup_college_scheduler.ui.AssignmentUI.AssignmentFragment;

import java.util.ArrayList;

public class CourseFragment extends Fragment {

    private String param1;
    private String param2;

    public static CourseAdapter itemAdapter;
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
        return inflater.inflate(R.layout.fragment_courses,
                container, false);
    }

    @Override
    public void
    onViewCreated(@NonNull View view,
                  @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<Course> courseList
                = CourseList.getCourseData();
        this.itemAdapter = new CourseAdapter(courseList);
        // Set the LayoutManager that
        // this RecyclerView will use.
        RecyclerView recyclerView
                = view.findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(getContext()));
        // adapter instance is set to the
        // recyclerview to inflate the items.
        recyclerView.setAdapter(itemAdapter);

        Button openDialog = view.findViewById(R.id.addCourseButton);
        openDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(view.getContext());
                dialog.setCancelable(true);
                dialog.setContentView(R.layout.fragment_add_new_course);

                EditText nameEt = dialog.findViewById(R.id.newCourseName);
                EditText instructorEt = dialog.findViewById(R.id.newCourseInstructor);
                EditText descriptionEt = dialog.findViewById(R.id.newCourseDescription);
                EditText timesEt = dialog.findViewById(R.id.newCourseTimes);
                Button submitButton = dialog.findViewById(R.id.newCourseAddButton);

                submitButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = nameEt.getText().toString();
                        String description = descriptionEt.getText().toString();
                        String instructor = instructorEt.getText().toString();
                        String times = timesEt.getText().toString();
                        CourseFragment.itemAdapter.addNewCourse(new Course(name, description, instructor, times));
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });
    }


    public static CourseFragment newInstance(String param1,
                                             String param2)
    {
        CourseFragment fragment = new CourseFragment();
        Bundle args = new Bundle();
        args.putString("param1", param1);
        args.putString("param2", param2);
        fragment.setArguments(args);
        return fragment;
    }
}