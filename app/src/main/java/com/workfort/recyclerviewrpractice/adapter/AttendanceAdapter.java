package com.workfort.recyclerviewrpractice.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.workfort.recyclerviewrpractice.viewholder.AttendanceViewHolder;
import com.workfort.recyclerviewrpractice.R;
import com.workfort.recyclerviewrpractice.model.StudentEntity;
import com.workfort.recyclerviewrpractice.databinding.RowStudentBinding;

import java.util.ArrayList;

public class AttendanceAdapter extends RecyclerView.Adapter<AttendanceViewHolder> {

    private ArrayList<StudentEntity> mStudents = new ArrayList<>();

    public void setStudents(ArrayList<StudentEntity> students) {
        mStudents = students;
        notifyDataSetChanged();
    }

    public void addStudent(StudentEntity student) {
        mStudents.add(student);
        notifyItemInserted(mStudents.size());
    }

    @NonNull
    @Override
    public AttendanceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RowStudentBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.row_student, parent, false
        );

        return new AttendanceViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AttendanceViewHolder holder, int position) {

        StudentEntity student = mStudents.get(position);
        holder.bind(student);
    }

    @Override
    public int getItemCount() {
        return mStudents.size();
    }
}
