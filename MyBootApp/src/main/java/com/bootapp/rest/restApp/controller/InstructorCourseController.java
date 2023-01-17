package com.bootapp.rest.restApp.controller;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootapp.rest.restApp.model.Course;
import com.bootapp.rest.restApp.model.Instructor;
import com.bootapp.rest.restApp.model.InstructorCourse;
import com.bootapp.rest.restApp.model.service.CourseService;
import com.bootapp.rest.restApp.model.service.InstructorCourseService;
import com.bootapp.rest.restApp.model.service.InstructorService;
@RestController
@RequestMapping("/api/instructor/course")
public class InstructorCourseController 
{
	@Autowired
	private CourseService courseService; 
	@Autowired
	private InstructorService instructorService; 
	@Autowired
	private InstructorCourseService instructorCourseService ;
	@PostMapping("/add/{instructorId}/{courseId}")	
		public ResponseEntity<String> assignInstructorToCourse (@RequestBody InstructorCourse instructorCourse,
																													@PathVariable("courseId")int courseId,
																													@PathVariable("instructorId") int instructorId )
		{
			Optional<Course> optionalC=courseService.getById(courseId);
			if(! optionalC.isPresent()) 
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid CourseId Given");
			
			Optional<Instructor> optionalI=instructorService.getById(instructorId);
			if(! optionalI.isPresent()) 
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid InstructorId Given");
			Course course=optionalC.get();
			Instructor instructor=optionalI.get();
			instructorCourse.setCourse(course);
			instructorCourse.setInstructor(instructor);
			instructorCourseService.insert(instructorCourse);
			return ResponseEntity.status(HttpStatus.OK).body("Instructor assigned to course");			
		}
	}
	


