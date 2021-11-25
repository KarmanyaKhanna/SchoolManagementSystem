package com.saksham;

import java.util.ArrayList;
import java.util.Scanner;

public class CurrentUser {
    Scanner input = new Scanner(System.in);
    public User getInstance(String type){
        // Initiate The Admin
        Data.fillData();
        Admin fc = new Admin(Data.courseList, Data.studentList, Data.teacherList);

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
