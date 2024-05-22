//package com.example.demo;
//
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class MyCommandLineRunner implements CommandLineRunner {
//
//	@Autowired
//	TodoRepository todoRepository;
//
//	@Override
//	public void run(String... args) throws Exception {
//
//		Todo todo1 = new Todo(1, "個人演習を終わらせる", LocalDate.parse("2024-05-22"),LocalTime.parse("19:00:00"), false);
//		
//		todoRepository.save(todo1);
//		
//		// 全検索
//		List<Todo> todoList = todoRepository.findAll();
//		
//		// 全リスト表示
//		for (Todo p : todoList) {
//			System.out.println(p.getTask());
//			System.out.println(p.getDeadLineDate());
//			System.out.println(p.getDeadLineTime());
//		}
//		
//	}
//
//}
