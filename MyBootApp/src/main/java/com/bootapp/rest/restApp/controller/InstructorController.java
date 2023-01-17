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
import com.bootapp.rest.restApp.model.Instructor;
import com.bootapp.rest.restApp.model.service.InstructorService;
@RestController
@RequestMapping("api/instructor")
public class InstructorController {
	@Autowired
	private InstructorService instructorService;
	//Post Mapping 
	//post instructor 
	@PostMapping("/add")
	public ResponseEntity<String> postInstructor(@RequestBody Instructor instructor)
	{
		instructorService.postInstructor(instructor);
		return ResponseEntity.status(HttpStatus.OK).body("Instructor Added");
	}
	//Get All Instructors 
	@GetMapping("/getall")
	public List<Instructor>  getAllInstructors()
	{
		List<Instructor> list=instructorService.getAllInstrucotrs();
		return list;
	}
	//Get Instructor via id
	//HEnce post mapping will be used
	@PostMapping("/one/{id}")
	public ResponseEntity<Object> getInstructorById(@PathVariable("id") int id)
	{
		Optional<Instructor> optional =instructorService.getById( id);
		if(!optional.isPresent())
		{
			ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Id Given");
		}
		Instructor instructor=optional.get();
		return  ResponseEntity.status(HttpStatus.OK).body(instructor);
	}
	
	

}
