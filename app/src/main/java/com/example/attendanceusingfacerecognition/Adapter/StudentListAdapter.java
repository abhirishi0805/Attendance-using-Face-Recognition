package com.example.attendanceusingfacerecognition.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.attendanceusingfacerecognition.ModalClass.StudentList;
import com.example.attendanceusingfacerecognition.R;

import java.util.ArrayList;
import java.util.List;

public class StudentListAdapter extends RecyclerView.Adapter<StudentListAdapter.ViewHolder> {
    List<StudentList> list;
    Context context;

    public StudentListAdapter(Context context, ArrayList<StudentList> list) {
        this.list=list;
        this.context=context;
    }
    @NonNull
    @Override
    public StudentListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recycler_view_student_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentListAdapter.ViewHolder holder, int position) {
        holder.roll.setText(list.get(position).getRoll());
        holder.name.setText(list.get(position).getName());
        holder.click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView roll,name;
        ImageView click;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            roll=itemView.findViewById(R.id.text_roll);
            name=itemView.findViewById(R.id.text_name);
            click=itemView.findViewById(R.id.image_click);
        }
    }
}
