package com.example.demo.service;

import java.util.List;

import com.example.demo.DTO.StudentDTO;
import com.example.demo.model.Career;
import com.example.demo.model.Student;

public interface CareerService {
	public List<Career> getCareersByNumberOfStudents();
	public List<StudentDTO> getStudentsByCareerCity(int idCareer);
	public List<StudentDTO> getStudentByCareerByEgressDate(int idCareer);
}
