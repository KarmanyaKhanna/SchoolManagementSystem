package com.saksham;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Admin extends User{

    private ArrayList<Teacher> teachers = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Course> courses = new ArrayList<>();

    public Scanner sc = new Scanner(System.in);

    Admin(ArrayList<Course> courses, ArrayList<Student> students,ArrayList<Teacher> teachers){
        this.courses = courses;
        this.students =students;
        this.teachers = teachers;
    }

    public void addStudent() {
        System.out.println("Enter student name");
        String line1 = this.sc.nextLine();
        System.out.println("Enter student id");
        String line2 = this.sc.nextLine();
        System.out.println("Enter Attendance");
        int daysAttended = Integer.parseInt(this.sc.nextLine());

        List<Course> studentCourses = new ArrayList<>();

        courseCodeCheck: do {

            System.out.println("Enter Course's codes seperated by  ' , ' ");
            String line3 = this.sc.nextLine();
            String[] courseCodeArr = line3.split(Pattern.quote(","));


            for (String s : courseCodeArr) {

                Course course = this.getCourse(Integer.parseInt(s));
                if (course == null) {
                    System.out.println("Incorrect Course code/codes");
                    continue courseCodeCheck;
                }
                studentCourses.add(course);
            }
            break;
        }while(true);


        Student student = new Student(studentCourses, line1, Integer.parseInt(line2), daysAttended );

        if(this.students.contains(student)){
            System.out.println("Student already in the school");
            return;
        }

        this.students.add(student);
        printStudent(student);
    }

    public void deleteStudent() {
        System.out.println("Enter ID of student you want to delete");
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
        System.out.println("Enter id of student you want to edit");
        String id = this.sc.nextLine();
        while (id == null){
            id = this.sc.nextLine();
        }

        System.out.println("Enter 'name' to change name");
        System.out.println("Enter 'attendance' to change attendance ");
        System.out.println("Enter 'id' to change id ");
        System.out.println("Enter 'addcourse' to add course ");
        System.out.println("Enter 'deletecourse' to delete course");
        System.out.println("Enter 'addmarks' to add marks");
        System.out.println("----------------------------------------");
        System.out.println("Enter the command you want to perform");
        System.out.println("----------------------------------------");
        String line2 = this.sc.nextLine();
        Student student = this.getStudent(Integer.parseInt(id));
        line2 = line2.toLowerCase(Locale.ROOT);



//        SOUT ENTER NAME TO CHANGE NAME, ENTER ADDCOURSE TO ADD COURSE TO STUDENT etc

        switch (line2) {
            case "name" -> {
                System.out.println("Enter new name");
                String name = this.sc.nextLine();
                assert student != null;
                student.setName(name);
            }
            case "attendance" -> {
                System.out.println("Enter total number of days attended");
                String attendance = this.sc.nextLine();
                assert student != null;
                student.addDaysAttended(Integer.parseInt(attendance));
            }
            case "id" -> {
                System.out.println("Enter new ID of student");
                String studentID = this.sc.nextLine();
                assert student != null;
                student.setId(Integer.parseInt(studentID));
            }
            case "addcourse" -> {
                printCourses(this.courses);
                System.out.println("Enter Course ID you want to add");
                String courseID = this.sc.nextLine();
                Course courseToBeAdded = this.getCourse(Integer.parseInt(courseID));
                assert student != null;
                student.addCourse(courseToBeAdded);
            }
            case "deletecourse" -> {
                printCourses(this.courses);
                System.out.println("Enter Course ID you want to delete");
                String courseDeleteID = this.sc.nextLine();
                Course courseToBeDeleted = this.getCourse(Integer.parseInt(courseDeleteID));
                assert student != null;
                student.deleteCourse(courseToBeDeleted);
            }
            case "addmarks" -> {
                printCourses(this.courses);
                System.out.println("Enter the ID of course whose marks you want to set");
                String courseMarksID = this.sc.nextLine();
                System.out.println("Enter the number of marks");
                int marks = this.sc.nextInt();
                Course courseToBeMarked = this.getCourse(Integer.parseInt(courseMarksID));
                assert student != null;
                assert courseToBeMarked != null;
                String output = student.setMarks(courseToBeMarked, marks);
                System.out.println(output);
            }
        }

    }

    public void addTeacher() {
        System.out.println("Enter Teacher's Name");
        String name = this.sc.nextLine();
        System.out.println("Enter Teacher's ID");
        String id = this.sc.nextLine();


        List<Course> teacherCourses = new ArrayList<>();

        courseCodeCheck: do {

            System.out.println("Enter Course's codes seperated by  ' , ' ");
            String line3 = this.sc.nextLine();

            String[] courseCodeArr = line3.split(Pattern.quote(","));


            for (String s : courseCodeArr) {
                Course course = this.getCourse(Integer.parseInt(s));
                if (course == null) {
                    System.out.println("Incorrect Course code/codes");
                    continue courseCodeCheck;
                }
                teacherCourses.add(course);
            }
            break;
        }while(true);


        Teacher teacher = new Teacher(Integer.parseInt(id), name, teacherCourses);

        if(this.teachers.contains(teacher)){
            System.out.println("Teacher already in the school");
            return;
        }

        this.teachers.add(teacher);
        printTeacher(teacher);

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
        System.out.println("Enter ID of teacher you want to change");
        String id = this.sc.nextLine();
        System.out.println("Enter 'name' to change name");
        System.out.println("Enter 'id' to change id");
        System.out.println("Enter 'addcourse' to add courses ");
        System.out.println("Enter 'deletecourse' to delete course ");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Enter command you want to perform");
        String line2 = this.sc.nextLine();
        String line3 = this.sc.nextLine();

        Teacher teacher = this.getTeacher(Integer.parseInt(id));
        line2 = line2.toLowerCase(Locale.ROOT);

//        SOUT ENTER NAME TO CHANGE NAME, ENTER ADDCOURSE TO ADD COURSE TO STUDENT etc
        switch (line2) {
            case "name" -> {
                assert teacher != null;
                teacher.setName(line3);
            }
            case "id" -> {
                assert teacher != null;
                teacher.setID(Integer.parseInt(line3));
            }
            case "addcourse" -> {
//                SOUT LIST OF COURSES WITH CODES HERE and ask user for course id of course to be added
                String courseID = this.sc.nextLine();
                Course courseToBeAdded = this.getCourse(Integer.parseInt(courseID));
                assert teacher != null;
                teacher.addCourse(courseToBeAdded);
            }
            case "deletecourse" -> {
                // SOUT LIST OF COURSES WITH CODES HERE and ask user for course id of course to be added
                String courseDeleteID = this.sc.nextLine();
                Course courseToBeDeleted = this.getCourse(Integer.parseInt(courseDeleteID));
                assert teacher != null;
                teacher.deleteCourse(courseToBeDeleted);
            }
        }

    }

    public void calculateAttendance(){
        System.out.println("Enter ID of Student you want to get attendance of ");
        int ID = this.sc.nextInt();
        Student student = this.getStudent(ID);
        assert student != null;
        System.out.println("Student " + student.name + " attended " + student.daysAttended + " out of 270 days");
    }

    public Teacher getTeacher(int ID) {
        for (Teacher tc : this.teachers) {
            if (tc.getID() == ID) {
                return tc;
            }
        }
        return null;
    }

    private void printTeacher(Teacher teacher){
        System.out.print("Teacher's Name is " + teacher.name + " with ID:" + teacher.getID() + " and courses are :-");
        printCourses(teacher.courses);
    }

    public void printAllTeacher(){
        for (Teacher t: teachers) {
            printTeacher(t);
        }
    }

    public void printAllStudents(){
        for (Student s: students) {
            printStudent(s);
        }
    }

    private void printStudent(Student student){
        System.out.print("Student's Name is " + student.name + " with ID: " + student.getId() + " Attended " + student.daysAttended + " days out of 270 and his/her courses are :- ");
        printCourses(student.courses);
    }

    private void printCourses(List<Course> courses){
        for (Course course : courses) {
            System.out.println("Course Name: " + course.name + ", ID: " + course.courseID + ", Marks: " + course.marks + ", and Grade: " + course.grade);
        }
    }

    public Student getStudent(int ID) {
        for (Student student : this.students) {
            if (student.getId() == ID) {
                return student;
            }
        }
        return null;
    }

    private Course getCourse(int ID) {
        for (Course c : courses) {
            if (c.courseID == ID) {
                return c;
            }
        }
        return null;
    }

}