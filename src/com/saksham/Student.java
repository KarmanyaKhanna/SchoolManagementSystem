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

    public void setDaysAttended(int daysAttended) {
        this.daysAttended += daysAttended;
    }

    public String setMarks(Course course, int marks) {
        int courseID = course.courseID;
        for(int i = 0; i < this.courses.size(); i++) {
            Course c = this.courses.get(i);
            if (c.getCourseID() == courseID ) {
                course.marks = marks;
                return course.name + " marked " + course.marks + " marks.";
            }
        }
        return "No course found with this ID";
    }

    public void addCourse(Course c){
        this.courses.add(c);
    }

    public void deleteCourse(Course c){
        this.courses.remove(c);
    }

}
