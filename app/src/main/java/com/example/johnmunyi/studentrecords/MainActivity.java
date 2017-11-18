package com.example.johnmunyi.studentrecords;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.johnmunyi.studentrecords.DB.MyDbHandler;
import com.example.johnmunyi.studentrecords.model.Courses;
import com.example.johnmunyi.studentrecords.model.Quizes;

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
        dbHandler.insertStudent(1,"Mike Jones");
        dbHandler.insertStudent(2,"John Major");
        dbHandler.insertStudent(3,"Mape and Sons");

        dbHandler.insertCourse(1,"Fundamentals");
        dbHandler.insertCourse(2,"JSPD");
        dbHandler.insertCourse(3,"Stochastic");
        dbHandler.insertCourse(4,"Machine Learning");
        dbHandler.insertCourse(5,"Data Structures");
        dbHandler.insertCourse(6,"Linear Systems");
        dbHandler.insertCourse(8,"Foundations of SE");
        dbHandler.insertCourse(9,"Practicum");


        dbHandler.insertQuiz(1,"Quiz1", 1, 1, 94);
        dbHandler.insertQuiz(2,"Quiz2", 2, 2, 99);
        dbHandler.insertQuiz(3,"Quiz3", 3, 3, 88);
        dbHandler.insertQuiz(4,"Quiz4", 1, 2, 81);
        dbHandler.insertQuiz(5,"Quiz1", 1, 2, 88);

        courses = dbHandler.getAllCourses();
        ArrayAdapter<Courses> adapter = new ArrayAdapter<Courses>(
                this,
                R.layout.list_item_courses,
                R.id.text_view_course,
                courses
        );

        ListView courses_list = (ListView) this.findViewById(R.id.list_view_courses);
//        TextView myholder = (TextView) this.findViewById(R.id.text_view_course);
//        final String myid = myholder.getText().toString();
        courses_list.setAdapter(adapter);

        courses_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), QuizesTable.class);
                startActivity(intent);

//                Intent intentBundle = new Intent(getApplicationContext(), QuizesTable.class);
//                Bundle bundle = new Bundle();
//                bundle.putString("cid", myid);
            }
        });
    }
}