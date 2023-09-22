package com.husqvarna.todo.exceptions;

import lombok.Getter;

@Getter
public class EmployeeNotFoundException extends TodoTaskException {

	private static final long serialVersionUID = 1L;

	public EmployeeNotFoundException(String message) {
		super(message);
		
	}
}
