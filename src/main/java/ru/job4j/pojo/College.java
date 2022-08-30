package ru.job4j.pojo;

import java.util.Date;

public class College extends Student {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Stanislav Kondratev");
        student.setGroupNumber("Best group number 1");
        student.setDateOfRreceipt(new Date());
        System.out.println("On the current date, namely "
                + student.getDateOfRreceipt() + ", "
                + student.getFullName() + " is working hard in the "
                + student.getGroupNumber() + ", while being very awesome.");
    }
}
