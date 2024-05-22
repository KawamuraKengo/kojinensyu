package com.example.demo;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class MyService {

	@Autowired
	TodoRepository todoRepository;

	public List<Todo> getAllTodoList() {
		List<Todo> list = todoRepository.findAll();
		return list;
	}

	public List<Todo> getAllTodosSortedByTask() {
		return todoRepository.findAll().stream()
				.sorted((t1, t2) -> t1.getTask().compareToIgnoreCase(t2.getTask()))
				.collect(Collectors.toList());
	}

	public List<Todo> getAllTodosSortedByDeadLineDate() {
		return todoRepository.findAll().stream()
				.sorted((t1, t2) -> t1.getDeadLineDate().compareTo(t2.getDeadLineDate()))
				.collect(Collectors.toList());
	}

	public List<Todo> getAllTodosSortedByDeadLineTime() {
		return todoRepository.findAll().stream()
				.sorted((t1, t2) -> t1.getDeadLineTime().compareTo(t2.getDeadLineTime()))
				.collect(Collectors.toList());
	}

	public Todo getTodoById(int id) {
		Todo todo = todoRepository.findById(id);
		return todo;
	}

	@Transactional
	public void editTodo(Todo todo) {
		todoRepository.save(todo);
	}

	@Transactional
	public void deleteTodo(int id) {
		todoRepository.deleteById(id);
	}

	@Transactional
	public void addTodo(Todo todo) {
		todoRepository.save(todo);
	}

	//	public Optional<Todo> getTodoBylocalDate(LocalDate date) {
	//		Optional<Todo> todo = todoRepository.findByDeadLineDateLessThan(date);
	//		return Optional.of(todo.orElse(null));
	//	}
	public List<Todo> getTodoBylocalDate(LocalDate date) {
		return todoRepository.findByDeadLineDateLessThanEqualOrEveryDayIsTrue(date);
	}

}
