package com.bootapp.rest.restApp.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootapp.rest.restApp.model.Course;

import com.bootapp.rest.restApp.model.service.CourseService;
@RestController
@RequestMapping("/api/course")
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	
	//post Course

	@PostMapping("/add")
	public ResponseEntity<String> addCourse(@RequestBody Course course) 
	{
		courseService.insertCourse(course);
		return ResponseEntity.status(HttpStatus.OK).body("Course successfully added");		
	}
	//get all

	@GetMapping("/all")
	public List<Course> getCourse()
	{
		List<Course> list=courseService.getAllCourse();
		return list;
	}
	//Get Course via the id
	//via the post mapping
	
	@PostMapping("/one/{id}" )
	public ResponseEntity<Object> getCourseById(@PathVariable("id" )int id)
	{
		Optional<Course> optional =courseService.getById(id);
		if(!optional.isPresent())
		{
			ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Id Given");
		}
		Course course =optional.get();
		return  ResponseEntity.status(HttpStatus.OK).body(course);
		
	}
	
	

}
