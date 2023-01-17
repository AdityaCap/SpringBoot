package com.bootapp.rest.restApp.model.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootapp.rest.restApp.data.InstructorRepo;
import com.bootapp.rest.restApp.model.Instructor;
@Service
public class InstructorService {
	@Autowired
	private InstructorRepo instructorRepo;
	
	public void postInstructor(Instructor instructor)
	{
		 instructorRepo.save(instructor);		
	}
	public List<Instructor> getAllInstrucotrs() 
	{
		
		return instructorRepo.findAll();
	}
	public Optional<Instructor> getById(int id) {
		Optional<Instructor> optional=instructorRepo.findById(id);
		if(optional==null)
			return null;
		return optional;
	}

	

	

}
