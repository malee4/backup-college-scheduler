package com.example.backup_college_scheduler;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.backup_college_scheduler.back.Assigment.Assignment;
import com.example.backup_college_scheduler.back.Assigment.AssignmentAdapter;
import com.example.backup_college_scheduler.ui.AssignmentUI.AssignmentFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.backup_college_scheduler.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    Button openDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

//        openDialog = findViewById(R.id.addAssignmentButton);
//        openDialog.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                showCustomDialog();
//            }
//        });
    }

//    void showCustomDialog() {
//        Dialog dialog = new Dialog(MainActivity.this);
//        dialog.setCancelable(true);
//        dialog.setContentView(R.layout.fragment_add_new_assignment);
//
//        EditText nameEt = dialog.findViewById(R.id.newAssignmentName);
//        EditText courseEt = dialog.findViewById(R.id.newAssignmentCourse);
//        EditText dueDateEt = dialog.findViewById(R.id.newAssignmentDueDate);
//        Button submitButton = dialog.findViewById(R.id.newAssignmentAddButton);
//
//        submitButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String name = nameEt.getText().toString();
//                String course = courseEt.getText().toString();
//                String dueDate = dueDateEt.getText().toString();
//                AssignmentFragment.itemAdapter.addNewAssignment(new Assignment(name, course, dueDate));
//                dialog.dismiss();
//            }
//        });
//
//        dialog.show();
//    }

}