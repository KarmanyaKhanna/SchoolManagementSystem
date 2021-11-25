package com.saksham;
import java.util.List;


public class Teacher extends User{
    int ID;
    String name;
    List<Course> courses;

    public int getID() {
        return ID;
    }

    @Override
    public void modifyStudent() {
        CurrentUser.admin.modifyStudent();
    }

    @Override
    public void printAllStudents() {
        CurrentUser.admin.printAllStudents();
    }

    @Override
    public void calculateAttendance() {
        CurrentUser.setAdmin();
        CurrentUser.admin.calculateAttendance();
    }

    public Teacher(int ID, String name, List<Course> courses) {
        this.ID = ID;
        this.name = name;
        this.courses = courses;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void addCourse(Course c){
        this.courses.add(c);
    }

    public void deleteCourse(Course c){
        this.courses.remove(c);
    }

    public void setName(String name) {
        this.name = name;
    }

}
