package com.workfort.recyclerviewrpractice;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.workfort.recyclerviewrpractice.adapter.AttendanceAdapter;
import com.workfort.recyclerviewrpractice.databinding.ActivityMainBinding;
import com.workfort.recyclerviewrpractice.databinding.PromptAddStudentBinding;
import com.workfort.recyclerviewrpractice.model.StudentEntity;
import com.workfort.recyclerviewrpractice.util.SpaceItemDecoration;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    private AttendanceAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mBinding.rvAttendance.setLayoutManager(new LinearLayoutManager(this));
        mBinding.rvAttendance.addItemDecoration(new SpaceItemDecoration(64, 16));

        mAdapter = new AttendanceAdapter();
        mBinding.rvAttendance.setAdapter(mAdapter);

        loadStudents();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.action_add_new_student) {
            addStudent();
        }

        return super.onOptionsItemSelected(item);
    }

    private void loadStudents() {
        ArrayList<StudentEntity> students = new ArrayList<>();

        students.add(new StudentEntity("Fahim1", 171014054));
        students.add(new StudentEntity("Fahim2", 171014055));
        students.add(new StudentEntity("Fahim3", 171014056));
        students.add(new StudentEntity("Fahim4", 171014057));
        students.add(new StudentEntity("Fahim5", 171014058));
        students.add(new StudentEntity("Fahim6", 171014058));
        students.add(new StudentEntity("Fahim7", 171014058));
        students.add(new StudentEntity("Fahim8", 171014058));
        students.add(new StudentEntity("Fahim9", 171014058));
        students.add(new StudentEntity("Fahim10", 171014058));
        students.add(new StudentEntity("Fahim11", 171014058));
        students.add(new StudentEntity("Fahim12", 171014058));
        students.add(new StudentEntity("Fahim13", 171014058));
        students.add(new StudentEntity("Fahim14", 171014058));
        students.add(new StudentEntity("Fahim15", 171014058));
        students.add(new StudentEntity("Fahim16", 171014058));
        students.add(new StudentEntity("Fahim17", 171014058));
        students.add(new StudentEntity("Fahim18", 171014058));
        students.add(new StudentEntity("Fahim19", 171014058));
        students.add(new StudentEntity("Fahim20", 171014058));
        students.add(new StudentEntity("Fahim21", 171014058));
        students.add(new StudentEntity("Fahim22", 171014058));
        students.add(new StudentEntity("Fahim23", 171014058));
        students.add(new StudentEntity("Fahim24", 171014058));
        students.add(new StudentEntity("Fahim25", 171014058));
        students.add(new StudentEntity("Fahim26", 171014058));
        students.add(new StudentEntity("Fahim27", 171014058));
        students.add(new StudentEntity("Fahim28", 171014058));
        students.add(new StudentEntity("Fahim29", 171014058));
        students.add(new StudentEntity("Fahim30", 171014058));
        students.add(new StudentEntity("Fahim31", 171014058));
        students.add(new StudentEntity("Fahim32", 171014058));
        students.add(new StudentEntity("Fahim33", 171014058));

        mAdapter.setStudents(students);
    }

    private void addStudent() {
        LayoutInflater inflater = LayoutInflater.from(this);
        PromptAddStudentBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.prompt_add_student, null, false
        );

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setView(binding.getRoot())
                .setTitle(R.string.label_add_student)
                .create();

        binding.btnAdd.setOnClickListener(view -> {
            String name = binding.etName.getText().toString();
            String id = binding.etId.getText().toString();

            if(TextUtils.isEmpty(name)) {
                Toast.makeText(this, "Please enter the name", Toast.LENGTH_SHORT).show();
                return;
            }

            if(TextUtils.isEmpty(id) || !TextUtils.isDigitsOnly(id)) {
                Toast.makeText(this, "Please enter valid id", Toast.LENGTH_SHORT).show();
                return;
            }

            dialog.dismiss();

            StudentEntity newStudent = new StudentEntity(name, Integer.parseInt(id));
            mAdapter.addStudent(newStudent);
            mBinding.rvAttendance.smoothScrollToPosition(mAdapter.getItemCount());
        });

        dialog.show();
    }
}
