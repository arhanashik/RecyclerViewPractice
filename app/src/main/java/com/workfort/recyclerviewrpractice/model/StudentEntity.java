package com.workfort.recyclerviewrpractice.model;

public class StudentEntity {
    private String mName;
    private int mId;
    private Boolean mIsPresent;

    public StudentEntity() {

    }

    public StudentEntity(String name, int id) {
        this.mName = name;
        this.mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public Boolean isPresent() {
        return mIsPresent;
    }

    public void setPresent(Boolean isPresent) {
        this.mIsPresent = isPresent;
    }
}
