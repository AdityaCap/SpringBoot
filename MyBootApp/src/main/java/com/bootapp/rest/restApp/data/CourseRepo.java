package com.bootapp.rest.restApp.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootapp.rest.restApp.model.Course;

public interface CourseRepo extends JpaRepository<Course, Integer> {

}
