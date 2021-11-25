package com.saksham;

import java.util.ArrayList;
import java.util.Scanner;

public class CurrentUser {
    public static Scanner input = new Scanner(System.in);
    public static User getInstance(String type){
        // Initiate The Admin
        Data.fillData();
        System.out.println("    SIZE  " + Data.courseList.size());
        Admin fc = new Admin(Data.courseList, Data.studentList, Data.teacherList);
        System.out.println("-----------------------------------------------------");
        fc.printAllStudents();
        System.out.println("-----------------------------------------------------");
        switch (type) {
            case "Admin":
                return fc;

            case "Student": {
                System.out.println("Enter your Student ID");
                int ID = Integer.parseInt(input.next());
                return fc.getStudent(ID);
            }

            case "Teacher": {
                System.out.println("Enter your Teacher ID");
                int ID = Integer.parseInt(input.next());
                return fc.getTeacher(ID);
            }

        }
        return new Staff();
    }
}
