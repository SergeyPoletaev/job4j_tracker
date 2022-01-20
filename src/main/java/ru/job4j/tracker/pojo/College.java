package ru.job4j.tracker.pojo;

import java.time.LocalDate;

public class College {

    public static void main(String[] args) {
        Student student = new Student();
        student.setFirstName("Ivan");
        student.setLastName("Ivanovich");
        student.setSurname("Ivanov");
        student.setGroup("15-P");
        student.setStartDate(LocalDate.of(2022, 11, 1));
        System.out.println("firstName: " + student.getFirstName());
        System.out.println("lastName: " + student.getLastName());
        System.out.println("surname: " + student.getSurname());
        System.out.println("group: " + student.getGroup());
        System.out.println("startDate: " + student.getStartDate());
    }
}
