package com.husqvarna.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.husqvarna.todo.entity.TodoTask;

@Repository
public interface TodoRepository extends JpaRepository<TodoTask, Long> {

	
}
