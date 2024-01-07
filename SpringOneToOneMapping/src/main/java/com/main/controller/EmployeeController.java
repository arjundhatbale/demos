package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.entity.Employee;
import com.main.entity.onetomany.Teacher;
import com.main.repository.EmployeeRepository;
import com.main.repository.TeacherRepository;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	@PostMapping("/saveEmployees")
	public ResponseEntity<String> saveAllEmployee(@RequestBody List<Employee> emp){
		employeeRepository.saveAll(emp);
		return ResponseEntity.ok("saved Data");
	}
	
	@PostMapping("/saveTeachers")
	public ResponseEntity<String> saveAllTeacher(@RequestBody List<Teacher> teach){
		teacherRepository.saveAll(teach);
		return ResponseEntity.ok("Saved Teacher Data");
		
	}
}
