package com.example.vivek.EmployeeManagementSystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

//import com.example.vivek.EmployeeManagementSystem.dao.Employee;
import com.example.vivek.EmployeeManagementSystem.dao.EmployeeDao;
import com.example.vivek.EmployeeManagementSystem.entity.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDao employeedao;
	
	public ResponseEntity<List<Employee>> getAllEmployee(){
		try {
		return new ResponseEntity<>(employeedao.findAll(),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
		
	}
	
	public ResponseEntity<Employee> saveDetails(Employee employee) {
		try {
		return new ResponseEntity<>(employeedao.save(employee),HttpStatus.CREATED);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	public Employee getById(int id) {
		return employeedao.findById(id).orElse(null);
	}

	public List<Employee> getEmployeeByName(String Name){
		return employeedao.findByName(Name);
	}

	public List<Employee> getBySalary(float salary) {
		return employeedao.findBySalary(salary);
	}
	
	public String deleteById(int id) {
		employeedao.deleteById(id);;
		return "Employee record removed" +id;
	}

	public Employee updateEmployee(Employee employee) {
		
		Employee existngEmployee = employeedao.findById(employee.getId()).orElse(null);
		existngEmployee.setName(employee.getName());
		existngEmployee.setDob(employee.getDob());
		existngEmployee.setSalary(employee.getSalary());
		return employeedao.save(existngEmployee);
	}
	
	


}
