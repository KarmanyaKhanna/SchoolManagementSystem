package com.saksham;

import java.util.ArrayList;
import java.util.List;

public class Solution {

        public static void main(String[] args) {
            ArrayList<Course> initial = new ArrayList<Course>();
            initial.add( new Course("OOP", 213));
            initial.add( new Course("DD", 211));
            initial.add( new Course("ENG", 249));
            initial.add( new Course("LICS", 890));
            Admin fc = new Admin(initial);

            int noOfCommands = Integer.parseInt(fc.sc.nextLine());
            for(int i = 0; i < noOfCommands; i++) {
                int command = Integer.parseInt(fc.sc.nextLine());

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

