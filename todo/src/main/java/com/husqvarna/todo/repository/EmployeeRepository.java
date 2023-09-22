package com.husqvarna.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.husqvarna.todo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	@Query("select e from Employee e where e.todoTask.taskId = :taskId")
	List<Employee> findEmployeesForTaskId(@Param("taskId") Long taskId);
	
}
