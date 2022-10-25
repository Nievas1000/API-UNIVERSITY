package com.example.demo.DTO;

import java.util.List;

public class ReportDTO {
	
	private CareerDTO carrera;
	private List<StudentDTO> students;
	
	public ReportDTO(CareerDTO carrera, List<StudentDTO> students) {
		super();
		this.carrera = carrera;
		this.students = students;
	}

	public CareerDTO getCarrera() {
		return carrera;
	}

	public void setCarrera(CareerDTO carrera) {
		this.carrera = carrera;
	}

	public List<StudentDTO> getStudents() {
		return students;
	}

	public void setStudents(List<StudentDTO> students) {
		this.students = students;
	}
	
	
}
