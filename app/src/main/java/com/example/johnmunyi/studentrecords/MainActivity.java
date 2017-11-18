package com.example.johnmunyi.studentrecords;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MyDbHandler dbHandler;
    private String name;
    private int version;
    private SQLiteDatabase.CursorFactory factory;
    private ArrayList<Courses> courses;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHandler = new MyDbHandler(this, name, factory, version);
        dbHandler.insertStudent("Mike Jones");
        dbHandler.insertStudent("John Major");
        dbHandler.insertStudent("Mape and Sons");

        dbHandler.insertCourse("Fundamentals");
        dbHandler.insertCourse("JSPD");
        dbHandler.insertCourse("IoT");

//        dbHandler.insertQuiz("Quiz1", 1, 1, 94);
//        dbHandler.insertQuiz("Quiz2", 2, 2, 99);
//        dbHandler.insertQuiz("Quiz3", 3, 3, 88);
//        dbHandler.insertQuiz("Quiz4", 1, 2, 81);

        courses = dbHandler.getAllCourses();
        ArrayAdapter<Courses> adapter = new ArrayAdapter<Courses>(
                this,
                R.layout.list_item_courses,
                R.id.text_view_course,
                courses
        );

        ListView courses_list = (ListView) this.findViewById(R.id.list_view_courses);
        courses_list.setAdapter(adapter);
    }
}
