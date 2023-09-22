package com.husqvarna.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.husqvarna.todo.entity.Employee;
import com.husqvarna.todo.exceptions.EmployeeNotFoundException;
import com.husqvarna.todo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	
	public List<Employee> getAllEmployees(){
		return repository.findAll();
	}
	
	public List<Employee> findEmployeesForTaskId(Long taskId) {
		return repository.findEmployeesForTaskId(taskId);
	}

	public List<Employee> createEmployee(Employee employee) {
		repository.save(employee);
		return getAllEmployees();
	}

	public Employee findEmployeeById(Long id) {
		
		return repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found for id = " + id));
	}
	
}
