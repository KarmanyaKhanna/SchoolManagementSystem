package com.saksham;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Admin {

    private ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    private ArrayList<Student> students = new ArrayList<Student>();
    private final ArrayList<Course> courses;

    public Scanner sc = new Scanner(System.in);

    Admin(ArrayList<Course> courses){
        this.courses = courses;
        printCourses(courses);
    }

    public void addStudent() {
        System.out.println("Enter student name");
        String line1 = this.sc.nextLine();
        System.out.println("Enter student id");
        String line2 = this.sc.nextLine();
        System.out.println("Enter course code seperated by commas");
        String line3 = this.sc.nextLine();

        String[] courseCodeArr = line3.split(Pattern.quote(","));

        ArrayList<Course> studentCourses = new ArrayList<Course>();

        for (String s : courseCodeArr) {
            Course course = this.getCourse(Integer.parseInt(s));
            studentCourses.add(course);
        }

        Student student = new Student(studentCourses, line1, Integer.parseInt(line2) );

        if(this.students.contains(student)){
            System.out.println("Student already in the school");
            return;
        }

        this.students.add(student);
        printStudent(student);
    }

    public void deleteStudent() {
        String line1 = this.sc.nextLine();
        int ID = Integer.parseInt(line1);

        for(int i = 0; i < this.students.size(); i++) {
            Student student = this.students.get(i);
            if (student.getId() == ID ) {
                this.students.remove(student);
                System.out.println("Student with ID:" + ID +" deleted.");
                return;
            }
        }

        System.out.println("Student with ID:" + ID +" not found.");

    }

    public void modifyStudent() {
        String id = this.sc.nextLine();
        String line2 = this.sc.nextLine();
        String line3 = this.sc.nextLine();

        Student student = this.getStudent(Integer.parseInt(id));
        line2 = line2.toLowerCase(Locale.ROOT);

//        SOUT ENTER NAME TO CHANGE NAME, ENTER ADDCOURSE TO ADD COURSE TO STUDENT etc

        switch (line2){
            case "name":
                student.setName(line3);
                break;
            case "attendance":
                student.addDaysAttended(Integer.parseInt(line3));
                break;
            case "id":
                student.setId(Integer.parseInt(line3));
                break;
            case "addcourse":
//                SOUT LIST OF COURSES WITH CODES HERE and ask user for course id of course to be added
                String courseID = this.sc.nextLine();
                Course courseToBeAdded = this.getCourse(Integer.parseInt(courseID));
                student.addCourse(courseToBeAdded);
                break;
            case "deletecourse":
                // SOUT LIST OF COURSES WITH CODES HERE and ask user for course id of course to be added
                String courseDeleteID = this.sc.nextLine();
                Course courseToBeDeleted = this.getCourse(Integer.parseInt(courseDeleteID));
                student.deleteCourse(courseToBeDeleted);
                break;
            case "addmarks":
                // SOUT LIST OF COURSES WITH CODES HERE and ask user for course id of course jiske marks dene hai student ko
                String courseMarksID = this.sc.nextLine();
                int marks = this.sc.nextInt();
                Course courseToBeMarked = this.getCourse(Integer.parseInt(courseMarksID));
                String output = student.setMarks( courseToBeMarked, marks);
                System.out.println(output);
                break;
        }

    }

    public void addTeacher() {
        System.out.println("Enter Teacher's Name");
        String name = this.sc.nextLine();
        System.out.println("Enter Teacher's ID");
        String id = this.sc.nextLine();
        System.out.println("Enter Course's codes seperated by  ' , ' ");
        String line3 = this.sc.nextLine();

        String[] courseCodeArr = line3.split(Pattern.quote(","));

        List<Course> teacherCourses = null;

        for (String s : courseCodeArr) {
            Course course = this.getCourse(Integer.parseInt(s));
            teacherCourses.add(course);
        }

        Teacher teacher = new Teacher(Integer.parseInt(id), name, teacherCourses);

        if(this.teachers.contains(teacher)){
            System.out.println("Student already in the school");
            return;
        }

        this.teachers.add(teacher);


    }

    public void deleteTeacher() {
        System.out.println("Enter the id of teacher you want to delete");
        String line1 = this.sc.nextLine();
        int ID = Integer.parseInt(line1);

        for(int i = 0; i < this.teachers.size(); i++) {
            Teacher teacher = this.teachers.get(i);
            if (teacher.getID() == ID ) {
                this.teachers.remove(teacher);
                System.out.println("Teacher with ID:" + ID +" deleted.");
                return;
            }
        }

        System.out.println("Teacher with ID:" + ID +" not found.");

    }

    public void modifyTeacher() {

        String id = this.sc.nextLine();
        String line2 = this.sc.nextLine();
        String line3 = this.sc.nextLine();

        Teacher teacher = this.getTeacher(Integer.parseInt(id));
        line2 = line2.toLowerCase(Locale.ROOT);

//        SOUT ENTER NAME TO CHANGE NAME, ENTER ADDCOURSE TO ADD COURSE TO STUDENT etc
        switch (line2){
            case "name":
                teacher.setName(line3);
                break;
            case "id":
                teacher.setID(Integer.parseInt(line3));
                break;
            case "addcourse":
//                SOUT LIST OF COURSES WITH CODES HERE and ask user for course id of course to be added
                String courseID = this.sc.nextLine();
                Course courseToBeAdded = this.getCourse(Integer.parseInt(courseID));
                teacher.addCourse(courseToBeAdded);
                break;
            case "deletecourse":
                // SOUT LIST OF COURSES WITH CODES HERE and ask user for course id of course to be added
                String courseDeleteID = this.sc.nextLine();
                Course courseToBeDeleted = this.getCourse(Integer.parseInt(courseDeleteID));
                teacher.deleteCourse(courseToBeDeleted);
                break;
        }

    }

    public void calculateAttendance(){
        int ID = this.sc.nextInt();
        Student student = this.getStudent(ID);
        System.out.println("Student " + student.name + " attended " + student.daysAttended + "out of 270 days");
    }

    private Teacher getTeacher(int ID) {
        for(int i = 0; i < this.teachers.size(); i++) {
            Teacher tc = this.teachers.get(i);
            if (tc.getID() == ID) {
                return tc;
            }
        }
        return null;
    }

    public void printAllStudents(){
        for (Student s: students) {
            printStudent(s);
        }
    }

    private void printStudent(Student student){
        System.out.println("Student's Name is " + student.name + " with ID:" + student.getId() + "and courses are :-");
        printCourses(student.courses);
    }

    private void printCourses(List<Course> courses){
        for (int i = 0; i < courses.size(); i++) {
            System.out.println("Course Name:" + courses.get(i).name + ", Course ID:"+ courses.get(i).courseID);
        }
    }

    private Student getStudent(int ID) {
        for(int i = 0; i < this.students.size(); i++) {
            Student student = this.students.get(i);
            if (student.getId() == ID ) {
                return student;
            }
        }
        return null;
    }

    private Course getCourse(int ID) {

        for (int i = 0; i < courses.size(); i++) {
            Course c = courses.get(i);
            if (c.courseID == ID){

                return c;
            }
        }
        return null;
    }


}