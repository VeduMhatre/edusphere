package com.Vedant.EduSphere.repository;

import com.Vedant.EduSphere.entity.Course;
import org.springframework.stereotype.*;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

}
