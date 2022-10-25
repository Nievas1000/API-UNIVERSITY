package com.example.demo.serviceImpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.CareerStudentDTO;
import com.example.demo.DTO.StudentDTO;
import com.example.demo.model.Career;
import com.example.demo.model.Student;
import com.example.demo.model.StudentHistory;
import com.example.demo.repository.CareerRepository;
import com.example.demo.service.CareerService;

@Service
public class CareerServiceImpl implements CareerService {
	
	@Autowired
	private CareerRepository careerRepository;

	@Override
	public List<Career> getCareersByNumberOfStudents() {
		return careerRepository.getCareersByNumberOfStudents();
	}

	@Override
	public List<StudentDTO> getStudentsByCareerCity(int idCareer) {
		List<Student> students = careerRepository.getStudentsByCareerCity(idCareer);
		List<StudentDTO> studentsDTO = new ArrayList<>();
		for (Student student : students) {
			StudentDTO stu = new StudentDTO(student.getNames(), student.getLastname(), student.getAge(), student.getGenre(), student.getDni(), student.getNumberOfLibrety(), student.getResidenceCity(),this.getCareerStudentDTO(student));
			studentsDTO.add(stu);
		}
		return studentsDTO;
	}

	@Override
	public List<StudentDTO> getStudentByCareerByEgressDate(int idCareer) {
		List<Student> students = careerRepository.getStudentByCareerByEgressDate(idCareer);
		List<StudentDTO> studentsDTO = new ArrayList<>();
		for (Student student : students) {
			StudentDTO stu = new StudentDTO(student.getNames(), student.getLastname(), student.getAge(), student.getGenre(), student.getDni(), student.getNumberOfLibrety(), student.getResidenceCity(),this.getCareerStudentDTO(student));
			studentsDTO.add(stu);
		}
		return studentsDTO;
	}

	
	public List<CareerStudentDTO> getCareerStudentDTO(Student student){
		List<CareerStudentDTO> careersStudent = new ArrayList<>();
		if(!student.getCareers().isEmpty()) {
			for (StudentHistory sh : student.getCareers()) {
				CareerStudentDTO csDTO = new CareerStudentDTO(sh.getCareer(), sh.getInscriptionDate(), sh.getEgressDate(), sh.isGraduate());
				careersStudent.add(csDTO);
			}
		}
		return careersStudent;
	}
}
