package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.InscriptionDTO;
import com.example.demo.DTO.ReportDTO;
import com.example.demo.DTO.StudentHistoryDTO;
import com.example.demo.model.Student;
import com.example.demo.service.StudentHistoryService;
import com.example.demo.serviceImpl.StudentHistoryServiceImpl;

@RestController
@RequestMapping("/studentHistory")
public class StudentHistoryController {
	
	@Autowired(required = true)
	 private StudentHistoryServiceImpl studentHistoryService;
	 
	 @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	 public void insertStudentToCareer(@RequestBody InscriptionDTO inscription) {
		 System.out.println(inscription.getIdCareer());
		 studentHistoryService.insertStudentToCareer(inscription);
	 }
	 
	 
	 @RequestMapping(value = "/report",method = RequestMethod.GET, produces = "application/json")
		public List<ReportDTO> getReport() {
			return studentHistoryService.getReport();
		}
}
