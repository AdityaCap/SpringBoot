package com.bootapp.rest.restApp.data;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bootapp.rest.restApp.model.Department;
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
