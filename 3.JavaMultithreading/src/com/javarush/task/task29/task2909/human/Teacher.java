package com.javarush.task.task29.task2909.human;

public class Teacher extends UniversityPerson {
    private int numberOfStudents;

    @Override
    public String getPosition() {
        return "Преподаватель";
    }

    public Teacher(String name, int age, int numberOfStudents) {

        this.name = name;
        this.age = age;
        this.numberOfStudents = numberOfStudents;
    }

    public void live() {
        teach();
    }

    public void teach() {
    }

}