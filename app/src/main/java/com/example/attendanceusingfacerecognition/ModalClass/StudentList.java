package com.example.attendanceusingfacerecognition.ModalClass;

public class StudentList {
    String name;
    String roll;

    public StudentList() {
    }

    public StudentList(String name, String roll) {
        this.name = name;
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }
}
