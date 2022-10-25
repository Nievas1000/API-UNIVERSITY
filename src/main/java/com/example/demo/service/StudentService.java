package com.example.demo.service;

import java.util.List;

import com.example.demo.DTO.StudentDTO;

public interface StudentService {
	
	public StudentDTO getStudentByNumberOfLibrety(int number);
	public List<StudentDTO> getStudentsBySimpleOrdering();
	public List<StudentDTO> getStudentsByGenre(String genre);
	
	
}
