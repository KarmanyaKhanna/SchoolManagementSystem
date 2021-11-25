package com.saksham;
import java.util.List;

public class Course {
    String name;
    int marks;
    int courseID;
    String grade;

    public Course(String name, int courseID) {
        this.name = name;
        this.courseID = courseID;
    }

    public void calculateGrade(){
        if(marks > 90){
            grade = "A";
        } else if(marks > 80 && marks < 90){
            grade = "A-";
        } else if(marks > 70 && marks < 80){
            grade = "B";
        } else if(marks > 60 && marks < 70){
            grade = "B-";
        } else if(marks > 50 && marks < 60){
            grade = "C";
        } else if(marks > 40 && marks < 50){
            grade = "C-";
        } else if(marks > 33 && marks < 40){
            grade = "D";
        } else {
            grade = "FAIL";
        }
    }

//    List<Teacher> teachers;

    public int getCourseID() {
        return courseID;
    }
}
