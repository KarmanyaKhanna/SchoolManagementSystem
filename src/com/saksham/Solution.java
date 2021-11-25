package com.saksham;

import java.util.ArrayList;
import java.util.List;

public class Solution {

        public static void main(String[] args) {
            ArrayList<Course> initial = new ArrayList<>();
            initial.add( new Course("OOP", 213));
            initial.add( new Course("DD", 211));
            initial.add( new Course("ENG", 249));
            initial.add( new Course("LICS", 890));
            Admin fc = new Admin(initial);

            int noOfCommands = Integer.parseInt(fc.sc.nextLine());
            for(int i = 0; i < noOfCommands; i++) {
                System.out.println("Enter the command code");
                String input = fc.sc.nextLine();
                if (input == null || input.length() == 0){
//                    System.out.println("Enter the command code");
                    input = fc.sc.nextLine();
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
            }
        }

}

