package com.example.demo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.example.demo.dto.StudentDTO;
import com.example.demo.service.StudentService;






@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	
	// 학생 등록 화면 출력
	@GetMapping("/save")
	public String save() {
		return "save";
	}
	// 학생등록 처리
	@PostMapping("/save")
	public String save(@ModelAttribute StudentDTO studentDTO) {
		System.out.println("StudentDTO="+studentDTO);
		// StudnetService 클래스의 save 메서드로 StudentDTO 객체 전달
		studentService.save(studentDTO);
		return "index";
	}
	@GetMapping("/list")
	public String findAll(Model model) {
		// DB에서 목로 데이터를 가져옴
		List<StudentDTO> studentDTOs = studentService.findAll();
		model.addAttribute("studentList", studentDTOs);
		
		// list.html로 이동
		return "list";
	}
	
	@GetMapping("/student/{id}")
	public String findById(@PathVariable("id") Long id, Model model) {
		System.out.println("id = " + id);
		StudentDTO studentDTO = studentService.findById(id);
		model.addAttribute("student", studentDTO);
		
		return "detail";
	}
	
	
}
