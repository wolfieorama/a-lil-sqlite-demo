package com.example.johnmunyi.studentrecords;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by johnmunyi on 11/17/17.
 */

public class MyDbHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "grades.db";
    private static final String TABLE_STUDENTS = "students";
    private static final String COL_STD_NAME = "name";
    private static final String TABLE_COURSES = "courses";
    private static final String COL_CRS_NAME = "name";
    private static final String TABLE_QUIZES = "quizes";
    private static final String COL_QZ_NUM = "quiz_num";
    private static final String COL_CRS_ID = "courseId";
    private static final String COL_STD_ID = "studentId";
    private static final String COL_QZ_SCORE = "score";


    SQLiteDatabase mSqLiteDatabase;
    public MyDbHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create_table_students = "CREATE TABLE STUDENTS(ID INTEGER PRIMARY_KEY AUTO_INCREMENT," + COL_STD_NAME + " TEXT);";
        sqLiteDatabase.execSQL(create_table_students);

        String create_table_courses = "CREATE TABLE COURSES(ID INTEGER PRIMARY_KEY AUTO_INCREMENT, " + COL_CRS_NAME + " TEXT);";
        sqLiteDatabase.execSQL(create_table_courses);

        String create_table_quizes = "CREATE TABLE QUIZES(ID INTEGER PRIMARY_KEY AUTO_INCREMENT, " + COL_QZ_NUM + " TEXT, " + COL_CRS_ID + " INTEGER, " + COL_STD_ID + " INTEGER, " + COL_QZ_SCORE + " INTEGER);";
        sqLiteDatabase.execSQL(create_table_quizes);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertStudent(String name){
        mSqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_STD_NAME, name);
        mSqLiteDatabase.insert(TABLE_STUDENTS, null, values);
        mSqLiteDatabase.close();
    }

    public void insertCourse(String name){
        mSqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_CRS_NAME, name);
        mSqLiteDatabase.insert(TABLE_COURSES, null, values);
        mSqLiteDatabase.close();
    }

    public void insertQuiz(String quiz_num, int courseId, int studentId, int score){
        mSqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_QZ_NUM, quiz_num);
        values.put(COL_CRS_ID, courseId);
        values.put(COL_STD_ID, studentId);
        values.put(COL_QZ_SCORE, score);

        mSqLiteDatabase.insert(TABLE_QUIZES, null, values);
    }

    public void getAllStudents(){
        mSqLiteDatabase = this.getReadableDatabase();

        String selectStudents = "SELECT * FROM TABLE STUDENTS;";
        Cursor cursor = mSqLiteDatabase.rawQuery(selectStudents, null);

        if (cursor.moveToFirst()){
            do{
                int student_id = cursor.getInt(0);
                String student_name = cursor.getString(1);
            }while (cursor.moveToNext());
        }

        mSqLiteDatabase.close();
    }

//    ArrayList of Course returned here for the listView
    public ArrayList getAllCourses(){
        mSqLiteDatabase = this.getWritableDatabase();
        ArrayList<Courses> courses = new ArrayList<Courses>();

        String selectCourses = "SELECT * FROM TABLE COURSES";
        Cursor cursor = mSqLiteDatabase.rawQuery(selectCourses, null);

        if (cursor.moveToFirst()){
            do{
                Courses course = new Courses(cursor.getInt(0), cursor.getString(1));
                courses.add(course);
            }while (cursor.moveToNext());
        }
        mSqLiteDatabase.close();
        return courses;
    }
}
