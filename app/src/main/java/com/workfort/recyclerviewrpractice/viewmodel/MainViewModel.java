package com.workfort.recyclerviewrpractice.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.workfort.recyclerviewrpractice.model.StudentEntity;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {

    public MutableLiveData<ArrayList<StudentEntity>> mStudentsLiveData = new MutableLiveData<>();

    public void loadStudents() {
        mStudentsLiveData.postValue(prepareDummyStudent());
    }

    public void addNewStudent(StudentEntity newStudent) {
        ArrayList<StudentEntity> students = mStudentsLiveData.getValue();
        if(students == null) {
            students = new ArrayList<>();
        }
        students.add(newStudent);

        mStudentsLiveData.postValue(students);
    }

    private ArrayList<StudentEntity> prepareDummyStudent() {
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

        return students;
    }
}
