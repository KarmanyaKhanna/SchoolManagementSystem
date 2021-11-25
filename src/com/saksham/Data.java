package com.saksham;

import java.util.ArrayList;
import java.util.List;

public class Data {

    public static List<Course> getRandomCourseList(int number){
        List<Course> tempCourse = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            tempCourse.add(courseList.get((int)(4 * Math.random())));
        }
        return tempCourse;
    }

    public static void fillData(){

        Course oop = new Course("OOP", 213);
        Course dd = new Course("DD", 211);
        Course eng =new Course("ENG", 249);
        Course lics = new Course("LiCS",890);

        //////////////// Courses Added ///////////////

        courseList.add(oop);
        courseList.add(dd);
        courseList.add(eng);
        courseList.add(lics);

        /////////////// Students ///////////////

        studentList.add(new Student(getRandomCourseList(3), "Saksham", 1508, 178));
        studentList.add(new Student(getRandomCourseList(4), "Karmanya", 1201, 203));
        studentList.add(new Student(getRandomCourseList(2), "Aaina", 2301, 267));
        studentList.add(new Student(getRandomCourseList(3), "Chirag", 2039, 102));
        studentList.add(new Student(getRandomCourseList(3), "Harry", 1501, 269));
        studentList.add(new Student(getRandomCourseList(4), "Darshil", 2169, 78));

        ///////////// Teachers ////////////
        teacherList.add(new Teacher( 2301, "Amit", getRandomCourseList(3)));
        teacherList.add(new Teacher( 1219, "Prateek", getRandomCourseList(3)));
        teacherList.add(new Teacher( 3029, "Ashutosh", getRandomCourseList(3)));


    }
    public static ArrayList<Course> courseList = new ArrayList<>();
    public static ArrayList<Student> studentList = new ArrayList<>();
    public static ArrayList<Teacher> teacherList = new ArrayList<>();

}
