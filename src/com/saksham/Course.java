package com.saksham;
import java.util.List;

public class Course {
    String name;
    int marks;
    int courseID;
    List<Teacher> teachers;

    public int getCourseID() {
        return courseID;
    }
}
