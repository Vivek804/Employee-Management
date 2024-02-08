package com.example.vivek.EmployeeManagementSystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vivek.EmployeeManagementSystem.entity.Employee;

//import jakarta.persistence.Id;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {

	List<Employee> findByName(String name);

	List<Employee> findBySalary(float salary);
	
 
}
