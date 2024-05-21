package com.example.demo;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
	@Autowired
	MyService service;

	@GetMapping("/todoList")
	public String GetTodoList(Model model) {

		model.addAttribute("todos", service.getAllTodoList());

		return "todoList";
	}
	
	@GetMapping("/deadLine")
	public String searchPerson(@RequestParam("date") LocalDate date, Model model) {
		Optional<Todo> todo = service.getTodoBylocalDate(date);
		model.addAttribute("todos", todo);
		return "todoList";
	}

//	@GetMapping("/users/{name}")
//	public String getUsers(@PathVariable String name, Model model) {
//		System.out.println("name = " + name);
//		model.addAttribute("message", name + "さん、こんにちは！");
//		return "hello";
//	}
//
//	@GetMapping("/sample1_input")
//	public String sample1_Input(Model model) {
//		model.addAttribute("title", "入力画面1です。");
//		return "Sample1_input";
//	}
//
//	@GetMapping("/sample1_result")
//	public String sample1_result(@RequestParam String paramA, @RequestParam String paramB, @RequestParam String paramC,
//			Model model) {
//		model.addAttribute("paramA", paramA);
//		model.addAttribute("paramB", paramB);
//		model.addAttribute("paramC", paramC);
//		return "sample1_result";
//	}
//
//	@GetMapping("/sample2_input")
//	public String sample2_input(Model model) {
//		model.addAttribute("title", "入力画面2です。");
//		return "sample2_input";
//	}
//
//	@PostMapping("/sample2_result")
//	public String sample2_result(ThreeTextForm form, Model model) {
//		System.out.println("paramA : " + form.getParamA());
//		System.out.println("paramB : " + form.getParamB());
//		System.out.println("paramC : " + form.getParamC());
//		model.addAttribute("form", form);
//		return "sample2_result";
//	}
//
//	@GetMapping("/sample3_input")
//	public String sample3_input(Model model) {
//		model.addAttribute("title", "入力画面3です。");
//		model.addAttribute("form", new ThreeTextForm_Validated());
//		return "sample3_input";
//	}
//
//	@PostMapping("/sample3_result")
//	public String sample3_result(@Validated @ModelAttribute("form") ThreeTextForm_Validated form,
//			BindingResult bindingResult, Model model) {
//
//		System.out.println("paramA : " + form.getParamA());
//		System.out.println("paramB : " + form.getParamB());
//		System.out.println("paramC : " + form.getParamC());
//
//		if (bindingResult.hasErrors()) {
//			model.addAttribute("title", "入力画面3の再入力です。");
//			model.addAttribute("form", form);
//			return "sample3_input";
//		}
//
//		model.addAttribute("form", form);
//
//		return "sample3_result";
//	}
//
//	// 変数名とテンプレート内の objectの名前をそろえれば、下記の書き方もOK
//
//	@GetMapping("/sample4_input")
//	public String sample4_input(Model model) {
//		model.addAttribute("title", "入力画面4です。");
//		model.addAttribute("threeTextForm_Validated", new ThreeTextForm_Validated());
//		return "sample4_input";
//	}
//
//	@PostMapping("/sample4_result")
//	public String sample4_result(@Validated ThreeTextForm_Validated threeTextForm_Validated,
//			BindingResult bindingResult, Model model) {
//
//		System.out.println("paramA : " + threeTextForm_Validated.getParamA());
//		System.out.println("paramB : " + threeTextForm_Validated.getParamB());
//		System.out.println("paramC : " + threeTextForm_Validated.getParamC());
//
//		if (bindingResult.hasErrors()) {
//			model.addAttribute("title", "入力画面4の再入力です。");
//			model.addAttribute("threeTextForm_Validated", threeTextForm_Validated);
//			return "sample4_input";
//		}
//
//		model.addAttribute("threeTextForm_Validated", threeTextForm_Validated);
//
//		return "sample4_result";
//	}
}