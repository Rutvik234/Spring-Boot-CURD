package com.springexample.Employee.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springexample.Employee.api.EmployeeEntity;

public interface EmployeRepository extends JpaRepository<EmployeeEntity, Integer>{
	
	List<EmployeeEntity> findByName(String name);
	
	List<EmployeeEntity> findByRole(String role);
	
	List<EmployeeEntity> findByAge(int age);
}
