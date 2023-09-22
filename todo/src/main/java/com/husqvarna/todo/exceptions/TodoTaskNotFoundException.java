package com.husqvarna.todo.exceptions;

public class TodoTaskNotFoundException extends TodoTaskException {
	
	private static final long serialVersionUID = 1L;
	
	public TodoTaskNotFoundException(String message) {
		super(message);
	}
}