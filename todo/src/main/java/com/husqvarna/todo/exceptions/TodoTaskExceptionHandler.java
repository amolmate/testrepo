package com.husqvarna.todo.exceptions;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;



@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class TodoTaskExceptionHandler {

	
	@ExceptionHandler(TodoTaskNotFoundException.class)
	public ResponseEntity<Object> handleTodoTaskNotFoundException(TodoTaskNotFoundException ex,
            WebRequest request) {
		
		return new ResponseEntity<Object>(prepareResponse(ex), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<Object> handleEmployeeNotFoundException(EmployeeNotFoundException ex,
            WebRequest request) {
		
		return new ResponseEntity<Object>(prepareResponse(ex), HttpStatus.NOT_FOUND);
	}

	ErrorResponse prepareResponse(Exception exception) {
		ErrorResponse response = new ErrorResponse();
		response.setErrorMessage(exception.getMessage());
		response.setHttpResponseCode(HttpStatus.NOT_FOUND.value());
		return response;
	}
}