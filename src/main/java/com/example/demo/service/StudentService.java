package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.StudentDTO;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public void save(StudentDTO studentDTO) {
		System.out.println("StudentService.save()");
		System.out.println("StudentDTO = " + studentDTO);
		studentRepository.save(studentDTO);
		// TODO Auto-generated method stub
	}
	
	public List<StudentDTO> findAll() {
		return studentRepository.findAll();
	}
	
	public StudentDTO findById(Long id) {
		return studentRepository.findById(id);
	}
}
