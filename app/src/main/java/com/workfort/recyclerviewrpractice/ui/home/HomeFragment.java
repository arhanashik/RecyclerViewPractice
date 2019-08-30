package com.workfort.recyclerviewrpractice.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.workfort.recyclerviewrpractice.R;
import com.workfort.recyclerviewrpractice.adapter.AttendanceAdapter;
import com.workfort.recyclerviewrpractice.databinding.FragmentHomeBinding;
import com.workfort.recyclerviewrpractice.util.SpaceItemDecoration;
import com.workfort.recyclerviewrpractice.viewmodel.MainViewModel;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding mBinding;

    private MainViewModel mViewModel;

    private AttendanceAdapter mAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        if(getActivity() != null) {
            mViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
        }

        mBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_home, container, false
        );

        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mBinding.rvAttendance.setLayoutManager(new LinearLayoutManager(getContext()));
        mBinding.rvAttendance.addItemDecoration(new SpaceItemDecoration(64, 16));

        mAdapter = new AttendanceAdapter();
        mBinding.rvAttendance.setAdapter(mAdapter);

        observeData();
    }

    private void observeData() {
        mViewModel.mStudentsLiveData.observe(getViewLifecycleOwner(), studentEntities -> {
            if(studentEntities != null) {
                mAdapter.setStudents(studentEntities);

                mBinding.rvAttendance.smoothScrollToPosition(mAdapter.getItemCount());
            }
        });
    }
}