package com.saksham;
import java.util.List;


public class Student {
    List<Course> courses;
    String name;
    private int id;
    int daysAttended;

    Student(List<Course> courses, String name, int id) {
        this.courses = courses;
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addDaysAttended(int daysAttended) {
        this.daysAttended += daysAttended;
    }

    public String setMarks(Course course, int marks) {
        int courseID = course.courseID;
        for (Course c : this.courses) {
            if (c.getCourseID() == courseID) {
                course.marks = marks;
                return course.name + " marked " + course.marks + " marks.";
            }
        }
        course.calculateGrade();
        return "No course found with this ID";
    }

    public void addCourse(Course c){
        this.courses.add(c);
    }

    public void deleteCourse(Course c){
        this.courses.remove(c);
    }

}
