package com.TrungTinhFullStack.SpringBootFullCodeJPA.repository;

import com.TrungTinhFullStack.SpringBootFullCodeJPA.entity.Course;
import com.TrungTinhFullStack.SpringBootFullCodeJPA.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;
    @Test
    public void SaveCourseMaterial() {

        Course course = Course.builder()
                .title("DSA")
                .credit(6)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.TrungTinhFullStack.com")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterial() {
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
    }

}