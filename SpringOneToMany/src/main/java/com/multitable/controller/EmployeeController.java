package com.multitable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.multitable.pojo.Employee;
import com.multitable.repository.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@PostMapping("/samveEmployees")
	public ResponseEntity<String> saveEmployee(@RequestBody List<Employee> empData){
		employeeRepository.saveAll(empData);
		return ResponseEntity.ok("Data saved");
	}
	
	
}
