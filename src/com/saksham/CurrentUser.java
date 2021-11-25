package com.saksham;

import java.util.Scanner;

public class CurrentUser {
    public static Scanner input = new Scanner(System.in);
    public static Admin admin;

    public static void setAdmin() {
        Data.fillData();
        CurrentUser.admin = new Admin(Data.courseList, Data.studentList, Data.teacherList);
    }

    public static User getInstance(String type){
        // Initiate The Admin

        CurrentUser.setAdmin();

        switch (type) {
            case "admin":
                return admin;

            case "student": {
                System.out.println("Enter your Student ID");
                int ID = Integer.parseInt(input.nextLine());
                return admin.getStudent(ID);
            }

            case "teacher": {
                System.out.println("Enter your Teacher ID");
                int ID = Integer.parseInt(input.next());
                return admin.getTeacher(ID);
            }

        }
        return new User() {
            public int hashCode() {
                return 0;
            };
        };
    }
}
