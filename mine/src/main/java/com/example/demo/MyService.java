package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {
	
	@Autowired
	TodoRepository todoRepository;
	
	public List<Todo> getTodoList(){
		
		List<Todo> list=todoRepository.findAll();
		
		return list;
		
	}

}
