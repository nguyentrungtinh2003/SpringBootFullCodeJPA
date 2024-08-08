package com.TrungTinhFullStack.SpringBootFullCodeJPA.repository;

import com.TrungTinhFullStack.SpringBootFullCodeJPA.entity.Guardian;
import com.TrungTinhFullStack.SpringBootFullCodeJPA.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("trungtinhn300@gmail.com")
                .firstName("Tinh")
                .lastName("Trung")
                //.guardianName("Java")
                //.guardianEmail("java@gmail.com")
                //.guardianMobile("9999999999")
                .build();

        studentRepository.save(student);

    }

    @Test
    public void saveStudentWithGuardian() {

        Guardian guardian = Guardian.builder()
                .email("trungtinhn300@gmail.com")
                .name("Tinh")
                .mobile("9999999999")
                .build();

        Student student = Student.builder()
                .firstName("Tinh")
                .emailId("trungtinhn300@gmail.com")
                .lastName("Trung")
                .guardian(guardian)
                .build();

       studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void  printStudentByFirstName() {
        List<Student> students = studentRepository.findByFirstName("Tinh");
        System.out.println("Students = " + students);
    }

    @Test
    public void  printStudentByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("Tinh");
        System.out.println("Students = " + students);
    }

    @Test
    public void printStudentBasedOnGuardianName() {
        List<Student> students = studentRepository.findByGuardianName("Java");
        System.out.println("Students = " + students);
    }

    @Test
    public void printGetStudentByEmailAddress() {
        Student student = studentRepository.getStudentByEmailAddress("trungtinhn300@gmail.com");
        System.out.println("Students = " + student);
    }

    @Test
    public void printGetStudentFirstNameByEmailAddress() {
        String firstName = studentRepository.getStudentFirstNameByEmailAddress("trungtinhn300@gmail.com");
        System.out.println("FirstName = " + firstName);
    }

    @Test
    public void getStudentByEmailAddressNative() {
        Student student = studentRepository.getStudentByEmailAddressNative("trungtinhn300@gmail.com");
        System.out.println("Students = " + student);
    }

    @Test
    public void getStudentByEmailAddressNativeNameParam() {
        Student student = studentRepository.getStudentByEmailAddressNativeNameParam("trungtinhn300@gmail.com");
        System.out.println("Students = " + student);
    }

    @Test
    public void updateStudentNameByEmailId() {
        studentRepository.updateStudentNameByEmailId("Tinh","trungtinhn300@gmail.com");
    }

}