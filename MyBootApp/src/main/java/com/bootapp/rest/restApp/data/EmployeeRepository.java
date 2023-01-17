package com.bootapp.rest.restApp.data;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bootapp.rest.restApp.model.Employee;
public interface EmployeeRepository  extends JpaRepository<Employee, Integer>{

}

