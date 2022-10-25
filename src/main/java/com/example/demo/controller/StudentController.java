package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.StudentDTO;
import com.example.demo.model.Student;
import com.example.demo.serviceImpl.StudentServiceImpl;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired(required = true)
	private StudentServiceImpl studentService;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public List<StudentDTO> getStudents() {
		return studentService.getStudents();
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public void saveStudent(@RequestBody StudentDTO student) {
		studentService.saveStudent(student);
	}
	
	@RequestMapping(value = "/librety/{number}",method = RequestMethod.GET, produces = "application/json")
	public StudentDTO getStudentByNumberOfLibrety(@PathVariable int number) {
		return studentService.getStudentByNumberOfLibrety(number);
	}
	@RequestMapping(value = "/byLastname",method = RequestMethod.GET, produces = "application/json")
	public List<StudentDTO> getStudentsBySimpleOrdering(){
		return studentService.getStudentsBySimpleOrdering();
	}
	
	@RequestMapping(value = "/genre/{genre}",method = RequestMethod.GET, produces = "application/json")
	public List<StudentDTO> getStudentsByGenre(@PathVariable String genre){
		return studentService.getStudentsByGenre(genre);
	}
}
