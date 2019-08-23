package com.workfort.recyclerviewrpractice.viewholder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.workfort.recyclerviewrpractice.model.StudentEntity;
import com.workfort.recyclerviewrpractice.databinding.RowStudentBinding;

public class AttendanceViewHolder extends RecyclerView.ViewHolder {

    private RowStudentBinding mBinding;

    public AttendanceViewHolder(@NonNull RowStudentBinding binding) {
        super(binding.getRoot());

        mBinding = binding;
    }

    public void bind(StudentEntity student) {

        mBinding.tvName.setText(student.getName());

        mBinding.cbPresent.setOnCheckedChangeListener(null);
        mBinding.cbAbsent.setOnCheckedChangeListener(null);

        if(student.isPresent() == null) {
            mBinding.cbPresent.setChecked(false);
            mBinding.cbAbsent.setChecked(false);
        } else {
            if(student.isPresent()) {
                mBinding.cbPresent.setChecked(true);
                mBinding.cbAbsent.setChecked(false);
            } else {
                mBinding.cbPresent.setChecked(false);
                mBinding.cbAbsent.setChecked(true);
            }
        }

        mBinding.cbPresent.setOnCheckedChangeListener((compoundButton, checked) -> {
            if(checked) {
                mBinding.cbAbsent.setChecked(false);
                student.setPresent(true);
            }
        });

        mBinding.cbAbsent.setOnCheckedChangeListener((compoundButton, checked) -> {
            if(checked) {
                mBinding.cbPresent.setChecked(false);
                student.setPresent(false);
            }
        });
    }
}
