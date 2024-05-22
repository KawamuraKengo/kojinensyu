package com.example.demo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
	
	Todo findById(int id);
	List<Todo> findByDeadLineDate(LocalDate date);
	List<Todo> findByDeadLineTime(LocalTime time);
	List<Todo> findByTaskContaining(String task);
 	List<Todo> findByDeadLineDateLessThanEqualOrEveryDayIsTrue(LocalDate date);
	
}

