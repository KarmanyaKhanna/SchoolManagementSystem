package com.saksham;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

        public static void main(String[] args) {

            Scanner in = new Scanner(System.in);

//            CurrentUser cu = new CurrentUser();
            String str = in.nextLine();
            User fc = CurrentUser.getInstance(str);

            fc.printAllStudents();

            System.out.println("Command 0 will add student");
            System.out.println("Command 1 will delete student");
            System.out.println("Command 2 will update student details");
            System.out.println("Command 3 will print all students and their details");
            System.out.println("Command 11 will add teacher");
            System.out.println("Command 100 will delete teacher");
            System.out.println("Command 101 will update teacher details");
            System.out.println("Command 110 will calculate attendance");
            System.out.println("Command 200 will print your ID");
            System.out.println("Command 201 will print your attendance");
            System.out.println("Command 202 will print your marks");

            System.out.println("Enter no. of commands you want to implement");

            int noOfCommands = Integer.parseInt(in.nextLine());
            for(int i = 0; i < noOfCommands; i++) {
                System.out.println("Enter the command code");
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
                ////////////////// Teacher Accessible ///////////////
            }
        }

}

