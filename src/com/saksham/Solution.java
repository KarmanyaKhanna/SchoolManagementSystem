package com.saksham;

import java.util.Locale;
import java.util.Scanner;

public class Solution {

        public static void printInstructions(String str){
        if (str.equals("admin") || str.equals("teacher")){
            if (str.equals("admin")){
                System.out.println("Command 0 will add student");
                System.out.println("Command 1 will delete student");
                System.out.println("Command 11 will add teacher");
                System.out.println("Command 100 will delete teacher");
                System.out.println("Command 101 will update teacher details");
                System.out.println("Command 102 will print all teacher details");
            }
            System.out.println("Command 2 will update student details");
            System.out.println("Command 3 will print all students and their details");
            System.out.println("Command 110 will calculate attendance");
        }else if (str.equals("student")){
            System.out.println("Command 200 will print your ID");
            System.out.println("Command 201 will print your attendance");
            System.out.println("Command 202 will print your marks");
        }
    }

        public static String userType(String username, String password){
            if (username.equals("Student") && password.equals("Stu@Pilani08")){
                return "student";
            }
            else if (username.equals("Admin") && password.equals("Admin@Insti64")){
                return "admin";
            } else if (username.equals("Teacher") && password.equals("Block@213")){
                return "teacher";
            }
            return "Incorrect username or password";
        }

        public static void main(String[] args) {

            Scanner in = new Scanner(System.in);

            String user;

            checkAuth:
            do{
                System.out.println("Enter Username and Password (both are case sensitive)");
                System.out.println("--------------------------------------------");
                System.out.println("Enter Username");
                String username = in.nextLine();
                System.out.println("Enter Password");
                String password = in.nextLine();

                user = userType(username,password);
                if (user.equals("Incorrect username or password")) {
                    continue checkAuth;
                } else {
                    break;
                }
            }
            while (true);

            User fc = CurrentUser.getInstance(user);

            System.out.println("Enter no. of commands you want to implement");

            int noOfCommands = Integer.parseInt(in.nextLine());
            for(int i = 0; i < noOfCommands; i++) {

                System.out.println("---------------------------------------------------------------------------------------------");
                printInstructions(user);
                System.out.println("--------------------------");
                System.out.println("Enter the command code");
                System.out.println("--------------------------");

                String input = in.nextLine();
                if (input == null || input.length() == 0){
                    input = in.nextLine();
                }

                int command = Integer.parseInt(input);

                if (command == 0){
                    fc.addStudent();
                }
                if (command == 1){
                    fc.deleteStudent();
                }
                if (command == 2){
                    fc.modifyStudent();
                }
                if (command == 3){
                    fc.printAllStudents();
                }
                if (command == 11){
                    fc.addTeacher();
                }
                if (command == 100){
                    fc.deleteTeacher();
                }
                if (command == 101){
                    fc.modifyTeacher();
                }
                if (command == 102){
                    fc.printAllTeacher();
                }
                if (command == 110){
                    fc.calculateAttendance();
                }
                //////////////////// Student Accessible /////////////////////////
                if (command == 200){
                    fc.printID();
                }
                if (command == 201){
                    fc.printAttendance();
                }
                if (command == 202){
                    fc.printMarks();
                }
            }
        }

}

