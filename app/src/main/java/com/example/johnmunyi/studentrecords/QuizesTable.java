package com.example.johnmunyi.studentrecords;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.johnmunyi.studentrecords.DB.MyDbHandler;
import com.example.johnmunyi.studentrecords.model.Quizes;

import java.util.ArrayList;

public class QuizesTable extends AppCompatActivity {
    private ArrayList<Quizes> quizes;
    private MyDbHandler dbHandler;
    private String name;
    private int version;
    private SQLiteDatabase.CursorFactory factory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizes_table);
        dbHandler = new MyDbHandler(this, name, factory, version);

        quizes = dbHandler.getCourseSpecificQuizes(1);
    }
}
