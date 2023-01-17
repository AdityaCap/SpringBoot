package com.bootapp.rest.restApp.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootapp.rest.restApp.model.InstructorCourse;

public interface InstructorCourseRepo extends JpaRepository<InstructorCourse, Integer> {

}
