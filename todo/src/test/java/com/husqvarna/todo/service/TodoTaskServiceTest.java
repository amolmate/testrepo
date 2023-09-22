package com.husqvarna.todo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import com.husqvarna.todo.entity.TodoTask;
import com.husqvarna.todo.exceptions.TodoTaskNotFoundException;
import com.husqvarna.todo.repository.TodoRepository;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class TodoTaskServiceTest {

	@InjectMocks
	private TodoTaskService service;
	
	@Mock
	private TodoRepository repository;
	
	
	@Test
	public void findTodoTaskByIdTest() {
		
		TodoTask task = new TodoTask();
		task.setCreatedAt(LocalDate.now());
		task.setTaskEndDate(LocalDate.now());
		task.setUpdatedAt(LocalDate.now());
		task.setTaskName("task1");
		task.setTaskDescription("task1");
		task.setTaskId(1l);
		
		
		Optional<TodoTask> optionalTask = Optional.of(task);
		
		Mockito.when(repository.findById(1L)).thenReturn(optionalTask);
		
		TodoTask todoTask = service.findTodoTaskById(1L);
		
		assertEquals("task1", todoTask.getTaskName());
		assertEquals("task1", todoTask.getTaskDescription());
		assertEquals(1l, todoTask.getTaskId());
		
	}	
	
	@Test()
	public void findTodoTaskForTaskIdNotPresentTest() {
		
		Optional<TodoTask> optionalTask = Optional.empty();
		
		Mockito.when(repository.findById(10L)).thenReturn(optionalTask);
		
		assertThrows(TodoTaskNotFoundException.class, () -> service.findTodoTaskById(10L));
	}
}