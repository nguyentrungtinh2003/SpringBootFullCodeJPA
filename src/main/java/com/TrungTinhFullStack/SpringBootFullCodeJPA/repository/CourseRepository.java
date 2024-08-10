package com.TrungTinhFullStack.SpringBootFullCodeJPA.repository;

import com.TrungTinhFullStack.SpringBootFullCodeJPA.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
}
