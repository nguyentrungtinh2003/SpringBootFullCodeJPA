package com.TrungTinhFullStack.SpringBootFullCodeJPA.repository;

import com.TrungTinhFullStack.SpringBootFullCodeJPA.entity.Course;
import com.TrungTinhFullStack.SpringBootFullCodeJPA.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {

        Course courseDSA = Course.builder()
                .title("DSA")
                .credit(5)
                .build();

        Course courseJava = Course.builder()
                .title("Java")
                .credit(6)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Tinh")
                .lastName("Trung")
                //.courses(List.of(courseDSA,courseJava))
                .build();

        teacherRepository.save(teacher);
    }
}