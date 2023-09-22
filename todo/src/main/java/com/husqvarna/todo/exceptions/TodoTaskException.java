package com.husqvarna.todo.exceptions;

import lombok.Getter;

@Getter
public class TodoTaskException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	
	public TodoTaskException(String message) {
		this(message, null);
	}
	
	public TodoTaskException(String message,  Throwable th) {
		super(message, th);
	}
}