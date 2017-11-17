package com.example.johnmunyi.studentrecords;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by johnmunyi on 11/17/17.
 */

public class MyDbHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "grades.db";
    private static final String TABLE_STUDENTS = "students";
    private static final String TABLE_COURSES = "courses";
    private static final String TABLE_QUIZES = "quizes";

    public MyDbHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create_table_students = "CREATE TABLE STUDENTS(ID INTEGER PRIMARY_KEY, NAME TEXT);";
        sqLiteDatabase.execSQL(create_table_students);

        String create_table_courses = "CREATE TABLE COURSES(ID INTEGER PRIMARY_KEY, NAME TEXT);";
        sqLiteDatabase.execSQL(create_table_courses);

        String create_table_quizes = "CREATE TABLE QUIZES(ID INTEGER PRIMARY_KEY, QUIZ_NUMBER TEXT, STUDENT_ID INTEGER, COURSE_ID INTEGER);";
        sqLiteDatabase.execSQL(create_table_quizes);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
