package com.TrungTinhFullStack.SpringBootFullCodeJPA.repository;

import com.TrungTinhFullStack.SpringBootFullCodeJPA.entity.Course;
import com.TrungTinhFullStack.SpringBootFullCodeJPA.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses() {
        List<Course> courses = courseRepository.findAll();
        System.out.println("Courses = " + courses);
    }

    @Test
    public void saveCourseWithTeacher() {

        Teacher teacher = Teacher.builder()
                .firstName("Trung")
                .lastName("Tinh")
                .build();

        Course course = Course.builder()
                .title("Python")
                .credit(6)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination() {
        Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
        Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);

        List<Course> firstPageCourses = courseRepository.findAll(firstPageWithThreeRecords).getContent();
        List<Course> secondPageCourses = courseRepository.findAll(secondPageWithTwoRecords).getContent();

        // In ra danh sách các khóa học để kiểm tra kết quả
        firstPageCourses.forEach(System.out::println);
        secondPageCourses.forEach(System.out::println);
    }

    @Test
    public void findAllSorting() {
        Pageable sortedByTitle = PageRequest.of(0, 3, Sort.by("title"));
        Pageable sortedByCreditDesc = PageRequest.of(0, 3, Sort.by("credit").descending());

        List<Course> sortedCoursesByTitle = courseRepository.findAll(sortedByTitle).getContent();
        List<Course> sortedCoursesByCreditDesc = courseRepository.findAll(sortedByCreditDesc).getContent();

        // In ra danh sách các khóa học để kiểm tra kết quả
        sortedCoursesByTitle.forEach(System.out::println);
        sortedCoursesByCreditDesc.forEach(System.out::println);
    }
}
