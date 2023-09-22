package com.husqvarna.todo.entity;



import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@jakarta.persistence.Entity
@jakarta.persistence.Table(name = "employee")
@Getter
@Setter
public class Employee extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = jakarta.persistence.GenerationType.SEQUENCE, generator = "emp_seq_gen")
	@SequenceGenerator(sequenceName = "emp_seq", allocationSize =  1, name = "emp_seq_gen", initialValue = 1)
	@Column(name = "emp_id")
	public long empId;
	
	@Column(name = "emp_name")
	@Size(min = 2, message = "Name should have at least 2 characters")
	public String empName;
	
	@Column(name = "emp_salary")
	@Positive(message = "Salary should be positive number")
	public double empSalary;
	
	//many employees working on one task
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	public TodoTask todoTask;
}