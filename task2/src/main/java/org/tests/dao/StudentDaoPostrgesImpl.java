package org.tests.dao;

import org.tests.domain.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StudentDaoPostrgesImpl implements StudentDao {

    private static final String INSERT_STUDENT = "INSERT INTO " +
            "students (sur_name, given_name, patronymic, group_name, date_of_birth) \n" +
            "VALUES \n" +
            "(?, ?, ?, ?, ?);";
    private static final String DELETE_STUDENT = "DELETE FROM students WHERE student_id = ?;";
    private static final String GET_ALL_STUDENTS= "SELECT * FROM students";

    @Override
    public Long addStudent(Student student) {
        Long result = -1L;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_STUDENT, new String[] {"student_id"})) {

            statement.setString(1, student.getSurName());
            statement.setString(2, student.getName());
            statement.setString(3, student.getPatronymic());
            statement.setString(4, student.getGroupName());
            statement.setDate(5, java.sql.Date.valueOf(student.getDateOfBirth()));
            statement.executeUpdate();

            ResultSet generatedKeysResultSet = statement.getGeneratedKeys();
            if (generatedKeysResultSet.next()) {
                result = generatedKeysResultSet.getLong(1);
            }
            generatedKeysResultSet.close();

        } catch (SQLException ex) {
            System.out.println("Error in inserting student: " + ex.getMessage());
        }

        return result;
    }

    @Override
    public boolean deleteStudent(Long id) {
        boolean result = false;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_STUDENT)) {

            statement.setLong(1, id);
            statement.executeUpdate();
            result = true;

        } catch (SQLException ex) {
            System.out.println("Error in deleting student: " + ex.getMessage());
        }

        return result;
    }

    @Override
    public List<Student> getStudents() {
        List<Student> studentList = new LinkedList<>();

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(GET_ALL_STUDENTS);

            while (resultSet.next()) {
                Student student = new Student();
                student.setStudentId(resultSet.getLong("student_id"));
                student.setName(resultSet.getString("given_name"));
                student.setSurName(resultSet.getString("sur_name"));
                student.setPatronymic(resultSet.getString("patronymic"));
                student.setGroupName(resultSet.getString("group_name"));
                student.setDateOfBirth(resultSet.getDate("date_of_birth").toLocalDate());

                studentList.add(student);
            }

        } catch (SQLException ex) {
            System.out.println("Error in getting list of student: " + ex.getMessage());
        }

        return studentList;
    }

    private Connection getConnection() throws SQLException {
        return ConnectionBuilder.getConnection();
    }
}
