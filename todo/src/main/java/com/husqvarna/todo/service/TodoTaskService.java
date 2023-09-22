package com.husqvarna.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.husqvarna.todo.entity.TodoTask;
import com.husqvarna.todo.exceptions.TodoTaskNotFoundException;
import com.husqvarna.todo.repository.TodoRepository;

@Service
public class TodoTaskService {
	
	@Autowired
	private TodoRepository todoRepository;
	
	public List<TodoTask> getAllTodoTasks(){
		return todoRepository.findAll();
	}
	
	public List<TodoTask> createTodoTask(TodoTask task){
		todoRepository.save(task);
		
		return getAllTodoTasks();
	}

	public TodoTask findTodoTaskById(Long id) {
		
		return todoRepository.findById(id)
				.orElseThrow(() -> new TodoTaskNotFoundException("TodoTask for Id = " + id + " not found"));
	}
}