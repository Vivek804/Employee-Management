package com.example.vivek.EmployeeManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.vivek.EmployeeManagementSystem.entity.Employee;
//import com.example.vivek.EmployeeManagementSystem.dao.Employee;
//import com.example.vivek.EmployeeManagementSystem.dao.EmployeeDao;
import com.example.vivek.EmployeeManagementSystem.service.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeservice;
	
	@GetMapping("/allemployee")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		return employeeservice.getAllEmployee();
	}
	
	@PostMapping("/addemployee")
	public ResponseEntity<Employee> postDetails(@RequestBody Employee employee) {
		return employeeservice.saveDetails(employee);
	}
	
	@GetMapping("/{id}")
	public Employee getById(@PathVariable int id) {
		return employeeservice.getById(id);
	}
	
	@GetMapping("/name/{Name}")
	public List<Employee> getEmployeeByName(@PathVariable String Name){
		return employeeservice.getEmployeeByName(Name);
	}
	
	@GetMapping("salary/{salary}")
	public List<Employee> getBySalary(@PathVariable float salary) {
		return employeeservice.getBySalary(salary);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmployeeById(@PathVariable int id) {
		return employeeservice.deleteById(id);
	}
	
	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeservice.updateEmployee(employee);
	}
}
