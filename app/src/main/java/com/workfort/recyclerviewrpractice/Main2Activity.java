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
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.workfort.recyclerviewrpractice.databinding.PromptAddStudentBinding;
import com.workfort.recyclerviewrpractice.model.StudentEntity;
import com.workfort.recyclerviewrpractice.viewmodel.MainViewModel;

public class Main2Activity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    private MainViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

//        mAppBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph())
//                .setDrawerLayout(drawer)
//                .build();

        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        mViewModel.loadStudents();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.action_add_new_student) {
            addStudent();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
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
            mViewModel.addNewStudent(newStudent);
        });

        dialog.show();
    }
}
