package com.example.demo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
	@Autowired
	MyService service;

//	Todoリスト画面
	@GetMapping("/todoList")
	public String getTodoList(Model model, @RequestParam(value = "sort", required = false) String sort) {
		List<Todo> todos;
		if (sort != null) {
			switch (sort) {
			case "task":
				todos = service.getAllTodosSortedByTask();
				break;
			case "deadLineDate":
				todos = service.getAllTodosSortedByDeadLineDate();
				break;
			case "deadLineTime":
				todos = service.getAllTodosSortedByDeadLineTime();
				break;
			default:
				todos = service.getAllTodoList();
				break;
			}
		} else {
			todos = service.getAllTodoList();
		}
		model.addAttribute("todos", todos);
		return "todoList";
	}

//	絞り込み
	@GetMapping("/deadLine")
	public String searchTodo(@RequestParam("date") LocalDate date, Model model) {
		List<Todo> todo = service.getTodoBylocalDate(date);
		model.addAttribute("todos", todo);
		return "todoList";
	}

//	編集画面へ
	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable("id") int id, Model model) {
		Todo todo = service.getTodoById(id);
		model.addAttribute("todo", todo);
		return "edit";
	}

//	編集追加画面
	@PostMapping("/edit")
	public String editTodo(@ModelAttribute("todo") Todo todo) {
		service.editTodo(todo);
		return "redirect:/todoList";
	}

//	削除
	@GetMapping("/delete/{id}")
	public String deleteTodo(@PathVariable("id") int id) {
		service.deleteTodo(id);
		return "redirect:/todoList";
	}

//	追加画面へ
	@GetMapping("/add")
	public String addTodo(@ModelAttribute("todo") Todo todo) {
		service.addTodo(todo);
		return "edit";
	}
}