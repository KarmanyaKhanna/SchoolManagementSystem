package com.saksham;

import java.util.List;

public class Staff extends User{
    public static volatile List<Student> students;
    public static void addStudent(Student student) {
        Staff.students.add(student);
    }
    public List<Student> getStudents() {
        return students;
    }
}
