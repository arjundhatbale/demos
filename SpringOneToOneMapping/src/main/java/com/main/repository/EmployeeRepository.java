package com.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.Employee;
import com.main.entity.onetomany.Teacher;

public interface EmployeeRepository extends JpaRepository< Employee, Integer> {
 
 

 

}
