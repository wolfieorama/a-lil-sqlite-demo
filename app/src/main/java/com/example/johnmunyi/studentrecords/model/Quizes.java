package com.example.johnmunyi.studentrecords.model;

/**
 * Created by johnmunyi on 11/18/17.
 */

public class Quizes {
    private String quiz_num;
    private int id,courseId, studentId, score;

    public Quizes(int id, String quiz_num, int courseId, int studentId, int score) {
        this.quiz_num = quiz_num;
        this.id = id;
        this.courseId = courseId;
        this.studentId = studentId;
        this.score = score;
    }

    public String getQuiz_num() {
        return quiz_num;
    }

    public void setQuiz_num(String quiz_num) {
        this.quiz_num = quiz_num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return studentId + " " + score;
    }
}
