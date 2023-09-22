package com.husqvarna.todo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

	@Column(name = "created_by")
	public String createdBy;
	
	@Column(name = "created_at")
	public LocalDate createdAt;
	
	@Column(name = "updated_by")
	public String updatedBy;
	
	@Column(name = "updated_at")
	public LocalDate updatedAt;
}