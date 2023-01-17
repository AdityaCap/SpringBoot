package com.bootapp.rest.restApp.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootapp.rest.restApp.data.InstructorCourseRepo;
import com.bootapp.rest.restApp.model.InstructorCourse;

@Service
public class InstructorCourseService {
	@Autowired
	private InstructorCourseRepo instructorCourseRepo;

	public void insert(InstructorCourse instructorCourse) {
		// TODO Auto-generated method stub
		instructorCourseRepo.save(instructorCourse);
		
	}

}
