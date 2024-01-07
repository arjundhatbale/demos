package com.multitable.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multitable.pojo.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
