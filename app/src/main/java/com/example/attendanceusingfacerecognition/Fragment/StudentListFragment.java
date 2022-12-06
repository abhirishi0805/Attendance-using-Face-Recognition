package com.example.attendanceusingfacerecognition.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.attendanceusingfacerecognition.Adapter.StudentListAdapter;
import com.example.attendanceusingfacerecognition.R;

public class StudentListFragment extends Fragment {
    RecyclerView recycler_view;
    StudentListAdapter adapter;
    Context ctx;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_studentlist, container, false);
        recycler_view=view.findViewById(R.id.recycler_view);
        recycler_view.setHasFixedSize(true);
        recycler_view.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        ctx = this.getActivity();
        return view;

    }
}
