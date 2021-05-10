package org.tests.dao;

import org.tests.domain.Student;

import java.util.List;

public interface StudentDao {
    Long addStudent(Student student);
    boolean deleteStudent(Long id);
    List<Student> getStudents();
}
