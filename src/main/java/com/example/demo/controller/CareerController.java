package com.example.demo.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.StudentDTO;
import com.example.demo.model.Career;
import com.example.demo.model.Student;
import com.example.demo.model.StudentHistory;
import com.example.demo.serviceImpl.CareerServiceImpl;

@RestController
@RequestMapping("/career")
public class CareerController {
	
	@Autowired
	private CareerServiceImpl careerService;
	
	@RequestMapping(value="/byNumberStudents",method = RequestMethod.GET, produces = "application/json" )
	public List<Career> getCareersByNumberOfStudents() {
		return careerService.getCareersByNumberOfStudents();
	}

	@RequestMapping(value="/studentsByCity/{idCareer}",method = RequestMethod.GET, produces = "application/json" )
	public List<StudentDTO> getStudentsByCareerCity(@PathVariable int idCareer) {
		return careerService.getStudentsByCareerCity(idCareer);
	}

}
