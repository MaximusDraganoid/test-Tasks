package org.tests.console;

import org.tests.dao.StudentDao;
import org.tests.dao.StudentDaoPostrgesImpl;
import org.tests.domain.Student;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ConsoleInterface {
    private StudentDao studentDao;
    private Scanner scanner;

    private static final String ADD_STUDENT = "add";
    private static final String DELETE_STUDENT = "delete";
    private static final String GET_ALL_STUDENTS = "get_list";
    private static final String EXIT = "exit";
    private static final String HELLO_MESSAGE = "Hello!" +
            "\nWelcome to test task 2 interface.";
    private static final String GOODBYE_MESSAGE = "Goodbye!";
    private static final String DEFAULT_MESSAGE = "No such command! Enter something else!";
    private static final String LIST_OF_COMMAND = "\nIf you want to insert student into table, please, enter " + ADD_STUDENT +
            "\nIf you want to delete student from table, please, enter " + DELETE_STUDENT +
            "\nIf you want to student's list, please, enter " + GET_ALL_STUDENTS +
            "\nIf you want to close app, please, enter " + EXIT + "\n";



    public ConsoleInterface() {
        studentDao = new StudentDaoPostrgesImpl();
        scanner = new Scanner(System.in);
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public void runInterface() {
        printHello();
        String input;
        while (!(input = scanner.nextLine()).equals(EXIT)) {
            runInterfaceLogic(input);
        }
        printGoodbye();
    }

    private void printHello() {
        System.out.println(HELLO_MESSAGE);
        System.out.println(LIST_OF_COMMAND);
    }

    private void printGoodbye() {
        System.out.println(GOODBYE_MESSAGE);
    }

    private void runInterfaceLogic(String input) {
        switch (input) {
            case (ADD_STUDENT):
                Student student = inputStudentData();
                Long id = studentDao.addStudent(student);
                System.out.println("Id of student is: " + id);
                System.out.println("Operation is done");
                break;
            case (DELETE_STUDENT):
                Long studentId = inputStudentId();
                boolean resultOfDeleting = studentDao.deleteStudent(studentId);
                System.out.println("Result of deleting: " + resultOfDeleting);
                System.out.println("Operation is done");
                scanner.nextLine();
                break;
            case (GET_ALL_STUDENTS):
                System.out.println("Student list: ");
                List<Student> list = studentDao.getStudents();
                printStudentList(list);
                System.out.println("Operation is done");
                break;
            default:
                printDefaultMessage();
        }
        System.out.println(LIST_OF_COMMAND);
        return;
    }

    private void printStudentList(List<Student> list) {
        list.stream().forEach(System.out::println);
    }


    private void printDefaultMessage() {
        System.out.println(DEFAULT_MESSAGE);
    }

    private Long inputStudentId() {
        Long studentId = 1L;
        System.out.println("Enter student id");
        studentId = scanner.nextLong();
        return studentId;
    }


    private Student inputStudentData() {
        Student student = new Student();

        System.out.println("Enter student surname");
        String surname = scanner.nextLine();
        student.setSurName(surname);

        System.out.println("Enter student name");
        String name = scanner.nextLine();
        student.setName(name);

        System.out.println("Enter student patronymic");
        String patronymic = scanner.nextLine();
        student.setPatronymic(patronymic);

        System.out.println("Enter student group name");
        String groupName = scanner.nextLine();
        student.setGroupName(groupName);

        System.out.println("Enter student date of birth in format yyyy-MM-dd");
        String date = scanner.nextLine();
        student.setDateOfBirth(LocalDate.parse(date));

        return student;
    }


}
