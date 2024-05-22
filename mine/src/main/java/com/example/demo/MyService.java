package com.example.demo;

import java.time.LocalDate;
import java.util.List;

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
	
	public void addTodo(Todo todo){
		todoRepository.save(todo);
	}

//	public Optional<Todo> getTodoBylocalDate(LocalDate date) {
//		Optional<Todo> todo = todoRepository.findByDeadLineDateLessThan(date);
//		return Optional.of(todo.orElse(null));
//	}
	public List<Todo> getTodoBylocalDate(LocalDate date) {
	    return todoRepository.findByDeadLineDateLessThanEqual(date);
	}

}
