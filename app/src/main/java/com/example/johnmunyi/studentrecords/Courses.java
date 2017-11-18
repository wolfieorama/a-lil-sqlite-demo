package com.example.johnmunyi.studentrecords;

/**
 * Created by johnmunyi on 11/18/17.
 */

public class Courses {

    private int id;
    private String name;

    public Courses(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Grades for: " + name;
    }
}
