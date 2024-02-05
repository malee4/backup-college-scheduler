package com.example.backup_college_scheduler;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.backup_college_scheduler.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

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
    }

}

//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.Fragment;
//
//public class MainActivity extends AppCompatActivity {
//    @Override
//    protected void onCreate(Bundle savedInstanceState)
//    {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        // Get a reference to the "btn_frag" button from the
//        // layout
//        Button btn = findViewById(R.id.btn_frag);
//
//        // Set an OnClickListener on the button
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override public void onClick(View v)
//            {
//                // When the button is clicked, replace
//                // the current fragment with a new
//                // instance of the FirstFragment
//                replaceFragment(new FirstFragment());
//
//                // Hide the button
//                btn.setVisibility(View.GONE);
//            }
//        });
//    }
//
//    // This method replaces the current fragment
//    // with a new fragment
//    public void replaceFragment(Fragment fragment)
//    {
//        // Get a reference to the FragmentManager
//        androidx.fragment.app
//                .FragmentManager fragmentManager
//                = getSupportFragmentManager();
//
//        // Start a new FragmentTransaction
//        androidx.fragment.app
//                .FragmentTransaction fragmentTransaction
//                = fragmentManager.beginTransaction();
//
//        // Replace the current fragment with the new
//        // fragment
//        fragmentTransaction.replace(R.id.frame_layout,
//                fragment);
//
//        // Commit the FragmentTransaction
//        fragmentTransaction.commit();
//    }
//}