package com.bootapp.rest.restApp.model.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootapp.rest.restApp.data.CourseRepo;
import com.bootapp.rest.restApp.model.Course;
@Service
public class CourseService {
	@Autowired
	private CourseRepo courseRepo;

	public void insertCourse(Course course) {
		courseRepo.save(course);		
	}
	public List<Course> getAllCourse() {
		
		return courseRepo.findAll();
	}
	public Optional<Course> getById(int cid) {
		Optional<Course> optional=courseRepo.findById(cid);
		if(optional==null)
			return null;
		return optional;
	}
}
