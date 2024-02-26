package com.springexample.Employee.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springexample.Employee.Repository.EmployeRepository;
import com.springexample.Employee.api.EmployeeEntity;

@RestController
public class EmployeeContoller {

	@Autowired
	EmployeRepository er;

	@GetMapping("/loading")
	public String m1() {

		return "Spring boot Application";
	}

	@PostMapping("/saveData")
	public String saveMethod(@RequestBody EmployeeEntity employeeEntity) {
		er.save(employeeEntity);
		return "Data Save Successfully";
	}

	@GetMapping("/fetchData")
	public EmployeeEntity fetchMethod(@RequestParam int id) {
		Optional<EmployeeEntity> optional = er.findById(id);
		EmployeeEntity employee = optional.get();
		return employee;
	}

	@PutMapping("/updateData")
	public String updateMethod(@RequestBody EmployeeEntity employee) {
		er.save(employee);
		return "Data Updated Successfully";
	}

	@DeleteMapping("/deleteData")
	public String deleteMethod(@RequestParam int id) {
		er.deleteById(id);
		return "Data Delete Successfully";
	}
	
	@GetMapping("/fetchAllData")
	public List<EmployeeEntity> fetchAllDataMethod(){
		List<EmployeeEntity> employee = er.findAll();
		return employee;
	}
	
	@GetMapping("/fetchDataByName")
	public List<EmployeeEntity> fetchNameMethod(@RequestParam String name) {
		return er.findByName(name);
	}
	
	@GetMapping("/fetchDataByRole")
	public List<EmployeeEntity> fetchRoleMethod(@RequestParam String role){
		return er.findByRole(role);
	}
	
	@GetMapping("/fetchDataByAge")
	public List<EmployeeEntity> fetchAgeMethod(@RequestParam int age){
		List<EmployeeEntity> employeeAge = er.findByAge(age);
		return employeeAge;
	}
	
	
	
	

}
