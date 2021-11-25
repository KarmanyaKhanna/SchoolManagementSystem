package com.saksham;

import java.util.ArrayList;
import java.util.Scanner;

public class CurrentUser {
    public static Scanner input = new Scanner(System.in);
    public static User getInstance(String type){
        // Initiate The Admin
        Data.fillData();
        Admin fc = new Admin(Data.courseList, Data.studentList, Data.teacherList);

        switch (type) {
            case "admin":
                return fc;

            case "student": {
                System.out.println("Enter your Student ID");
                int ID = Integer.parseInt(input.nextLine());
                Student stu = fc.getStudent(ID);
                return stu;
            }

            case "teacher": {
                System.out.println("Enter your Teacher ID");
                int ID = Integer.parseInt(input.next());
                return fc.getTeacher(ID);
            }

        }
        return new Staff();
    }
}
