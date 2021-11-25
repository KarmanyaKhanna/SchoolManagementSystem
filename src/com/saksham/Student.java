package com.saksham;
import java.util.List;


public class Student extends User{

    List<Course> courses;
    String name;
    private int id;
    int daysAttended;

    Student(List<Course> courses, String name, int id, int daysAttended) {
        this.courses = courses;
        this.name = name;
        this.id = id;
        this.daysAttended= daysAttended;
    }

    public int getId() {
        return this.id;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public String getName() {
        return name;
    }

    public int getDaysAttended() {
        return daysAttended;
    }

    public void printID(){
        System.out.println("Your ID is " + getId());
    }

    public void printAttendance() {
        System.out.println("You attended " + getDaysAttended() + " days out of 270 days.");
    }

    public void printMarks() {
        for (Course c: courses) {
            System.out.println(c.name + ": " + c.marks + " marks and " + c.grade + " grade.");
        }
    }

    // ADMIN ONLY
    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addDaysAttended(int daysAttended) {
        this.daysAttended = daysAttended;
    }

    public String setMarks(Course course, int marks) {
        int courseID = course.courseID;
        for (Course c : this.courses) {
            if (c.getCourseID() == courseID) {
                course.marks = marks;
                course.calculateGrade();
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
