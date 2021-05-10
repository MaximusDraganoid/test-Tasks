package org.tests.domain;

import java.time.LocalDate;

public class Student {
    private Long studentId;
    private String name;
    private String surName;
    private String patronymic;
    private LocalDate dateOfBirth;
    private String groupName;

    public Student() {
    }

    public Student(Long studentId, String name, String surName, String patronymic, LocalDate dateOfBirth, String groupName) {
        this.studentId = studentId;
        this.name = name;
        this.surName = surName;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.groupName = groupName;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
