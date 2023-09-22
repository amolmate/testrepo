package com.husqvarna.todo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.husqvarna.todo.entity.Employee;
import com.husqvarna.todo.entity.TodoTask;
import com.husqvarna.todo.service.EmployeeService;
import com.husqvarna.todo.service.TodoTaskService;

@RestController
@RequestMapping("/husqvarna/todo")
public class TodoTaskController {
	
	
	@Autowired
	private TodoTaskService todoTaskService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/todotasks")
	public List<TodoTask> getAllTodoTasks() {
		return todoTaskService.getAllTodoTasks();
	}
	
	@GetMapping("/todotask/{id}")
	public TodoTask findTodoTaskById(@PathVariable Long id) {
		return todoTaskService.findTodoTaskById(id);
	}
	
	@PostMapping("/task/create")
	@ResponseStatus(value = HttpStatus.CREATED)
	public List<TodoTask> createToDoTask(@Valid @RequestBody TodoTask task) {
		return todoTaskService.createTodoTask(task);
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@PostMapping("/employee/create")
	@ResponseStatus(value = HttpStatus.CREATED)
	public List<Employee> createEmployee(@RequestBody Employee employee){
		return employeeService.createEmployee(employee);
	}
	
	@GetMapping("/employee/{id}")
	public Employee findEmployeeById(@PathVariable Long id) {
		return employeeService.findEmployeeById(id);
	}
	
	@GetMapping("/{taskid}/employees")
	public List<Employee> findEmployeesByTaskId(@PathVariable("taskid") Long taskId) {
		return employeeService.findEmployeesForTaskId(taskId);
	}
	
	@GetMapping("/ping")
	public String getPing() {
		
		return "Hello Rest ";
	}
}