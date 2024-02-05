package com.example.backup_college_scheduler.ui.AssignmentUI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.backup_college_scheduler.Assignment;
import com.example.backup_college_scheduler.AssignmentAdapter;
import com.example.backup_college_scheduler.AssignmentList;
import com.example.backup_college_scheduler.Constants;
import com.example.backup_college_scheduler.Employee;
import com.example.backup_college_scheduler.FirstFragment;
import com.example.backup_college_scheduler.R;
import com.example.backup_college_scheduler.databinding.FragmentDashboardBinding;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {
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
        return inflater.inflate(R.layout.fragment_dashboard,
                container, false);
    }

    @Override
    public void
    onViewCreated(@NonNull View view,
                  @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<Assignment> assignmentList
                = AssignmentList.getAssignmentData();
        AssignmentAdapter itemAdapter = new AssignmentAdapter(assignmentList);
        // Set the LayoutManager that
        // this RecyclerView will use.
        RecyclerView recyclerView
                = view.findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(getContext()));
        // adapter instance is set to the
        // recyclerview to inflate the items.
        recyclerView.setAdapter(itemAdapter);
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