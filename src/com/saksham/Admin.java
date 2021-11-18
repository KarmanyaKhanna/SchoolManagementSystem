package com.saksham;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Admin {
    private ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    private ArrayList<Student> students = new ArrayList<Student>();
    private ArrayList<Course> courses = new ArrayList<Course>();
    int totalWorkingDays = 270;

    public Scanner sc = new Scanner(System.in);

    public void handle0000() {
        String line1 = this.sc.nextLine();
    }

    public void addStudent() {
        System.out.println("Enter stud");
        String line1 = this.sc.nextLine();
        String line2 = this.sc.nextLine();
        String line3 = this.sc.nextLine();

        String[] courseCodeArr = line3.split(Pattern.quote(","));

        List<Course> studentCourses = null;

        for (int i=0; i<courseCodeArr.length ;i++){
            Course course = this.getCourse(Integer.parseInt(courseCodeArr[i]));
            studentCourses.add(course);
        }

        Student student = new Student(studentCourses, line1, Integer.parseInt(line2) );

        if(this.students.contains(student)){
            System.out.println("Student already in the school");
            return;
        }

        this.students.add(student);


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
                student.setDaysAttended(Integer.parseInt(line3));
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



    private Teacher getTeacher(int ID) {
        for(int i = 0; i < this.teachers.size(); i++) {
            Teacher tc = this.teachers.get(i);
            if (tc.getID() == ID) {
                return tc;
            }
        }
        return null;
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
        for(int i = 0; i < this.courses.size(); i++) {
            Course c = this.courses.get(i);
            if (c.getCourseID() == ID ) {
                return c;
            }
        }
        return null;
    }

}