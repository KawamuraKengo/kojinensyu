package com.example.demo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
	
	List<Todo> findById(int id);
	List<Todo> findByDeadLineDate(LocalDate date);
	List<Todo> findByDeadLineTime(LocalTime time);
	List<Todo> findByTaskContaining(String task);
 	List<Todo> findByDeadLineDateLessThan(LocalDate date);
	
}

