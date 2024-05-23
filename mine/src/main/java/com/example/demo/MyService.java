package com.example.demo;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		            .sorted((t1, t2) -> {
		                if (t1.getDeadLineDate() == null && t2.getDeadLineDate() == null) {
		                    return 0;
		                }
		                if (t1.getDeadLineDate() == null) {
		                    return -1;
		                }
		                if (t2.getDeadLineDate() == null) {
		                    return 1;
		                }
		                return t1.getDeadLineDate().compareTo(t2.getDeadLineDate());
		            })
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

	public void editTodo(Todo todo) {
		todoRepository.save(todo);
	}

	public void deleteTodo(int id) {
		todoRepository.deleteById(id);
	}

	public void addTodo(Todo todo) {
		todoRepository.save(todo);
	}

	public List<Todo> getTodoBylocalDate(LocalDate date) {
		return todoRepository.findByDeadLineDateLessThanEqualOrEveryDayIsTrue(date);
	}

}
