package com.example.johnmunyi.studentrecords;

import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

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
        init();
    }

    public void init() {
        TableLayout qtable = (TableLayout) findViewById(R.id.quizes_table);
        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
        TextView courseTitle;
        TextView title;
        TextView header;
        TableRow row1= new TableRow(this);
        row1.setLayoutParams(lp);
        title = new TextView(this);
        title.setText("Course Title is: ");
        row1.addView(title);
        qtable.addView(row1);

        TableRow row2= new TableRow(this);
        row2.setLayoutParams(lp);
        header = new TextView(this);
        header.setText("Student Q1  Q2  Q3  Q4");
        row2.addView(header);
        qtable.addView(row2);

        for (int i = 0; i < quizes.size(); i++) {
            TableRow row= new TableRow(this);
            row.setLayoutParams(lp);
            courseTitle = new TextView(this);
            courseTitle.setText(String.valueOf(i+". " +quizes));

            row.addView(courseTitle);
            qtable.addView(row);
        }
    }
}
