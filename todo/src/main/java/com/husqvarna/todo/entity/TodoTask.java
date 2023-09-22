package com.husqvarna.todo.entity;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Future;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "todo_task")
public class TodoTask extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_seq")
	@SequenceGenerator(sequenceName = "todo_task_seq", allocationSize = 1, name = "task_seq", initialValue = 1)
	@Column(name = "task_id")
	public long taskId;
	
	@Column(name = "task_name", nullable = false, length = 512)
	public String taskName;
	
	@Column(name = "task_description", length = 512)
	public String taskDescription;
	
	@Column(name = "task_enddate", nullable = false)
	@Future(message = "Task end date must be in the future")
	public LocalDate taskEndDate;
	
	//One task handled by many employees
	@OneToMany(mappedBy = "todoTask")
	@JsonIgnore
	public List<Employee> employees;
}