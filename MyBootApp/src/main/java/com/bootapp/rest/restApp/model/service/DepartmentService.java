package com.bootapp.rest.restApp.model.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootapp.rest.restApp.data.DepartmentRepository;
import com.bootapp.rest.restApp.model.Department;
@Service
public class DepartmentService
{
	@Autowired
	private DepartmentRepository departmentRepository; 
	public void postEmployee(Department department) {
		// TODO Auto-generated method stub
		departmentRepository.save(department);
	}
	public Department getDepartmentById(int did) {
		Optional<Department> optional = departmentRepository.findById(did);

		//if department exists, optional will not be null 
		if(optional != null)
			 return optional.get(); //returning the department
		//if department does not exist, optional will be null 
		return null;
	}
}
