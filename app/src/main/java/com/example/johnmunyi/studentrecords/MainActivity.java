package com.example.johnmunyi.studentrecords;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    MyDbHandler dbHandler;
    private String name;
    private int version;
    private SQLiteDatabase.CursorFactory factory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHandler = new MyDbHandler(this, name, factory, version);
        dbHandler.insertStudent("Mike Jones");
        dbHandler.insertStudent("John Major");
        dbHandler.insertStudent("Mape and Sons");
    }
}
