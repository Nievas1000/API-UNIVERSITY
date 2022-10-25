package com.example.demo.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.CareerStudentDTO;
import com.example.demo.DTO.StudentDTO;
import com.example.demo.model.Student;
import com.example.demo.model.StudentHistory;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public List<StudentDTO> getStudents(){
		List<Student> students = studentRepository.findAll();
		List<StudentDTO> studentsDTO = new ArrayList<>();
		for (Student student : students) {
			StudentDTO stu = new StudentDTO(student.getNames(), student.getLastname(), student.getAge(), student.getGenre(), student.getDni(), student.getNumberOfLibrety(), student.getResidenceCity(),this.getCareerStudentDTO(student));
			studentsDTO.add(stu);
		}
		return studentsDTO;
	}

	@Override
	public StudentDTO getStudentByNumberOfLibrety(int number) {
		Student student =  studentRepository.getStudentByNumberOfLibrety(number);
		StudentDTO studentDTO = new StudentDTO(student.getNames(), student.getLastname(), student.getAge(), student.getGenre(), student.getDni(), student.getNumberOfLibrety(), student.getResidenceCity(), this.getCareerStudentDTO(student));
		return studentDTO;
	}

	@Override
	public List<StudentDTO> getStudentsBySimpleOrdering() {
		List<Student> students =  studentRepository.getStudentsBySimpleOrdering();
		List<StudentDTO> studentsDTO = new ArrayList<>();
		for (Student student : students) {
			StudentDTO stu = new StudentDTO(student.getNames(), student.getLastname(), student.getAge(), student.getGenre(), student.getDni(), student.getNumberOfLibrety(), student.getResidenceCity(),this.getCareerStudentDTO(student));
			studentsDTO.add(stu);
		}
		return studentsDTO;
	}

	@Override
	public List<StudentDTO> getStudentsByGenre(String genre) {
		List<Student> students = studentRepository.getStudentsByGenre(genre);
		List<StudentDTO> studentsDTO = new ArrayList<>();
		for (Student student : students) {
			StudentDTO stu = new StudentDTO(student.getNames(), student.getLastname(), student.getAge(), student.getGenre(), student.getDni(), student.getNumberOfLibrety(), student.getResidenceCity(),this.getCareerStudentDTO(student));
			studentsDTO.add(stu);
		}
		return studentsDTO;
	}
	
	public void saveStudent(StudentDTO s) {
		Student student = new Student(s.getNames(), s.getLastname(), s.getAge(),s.getGenre(), s.getDni(), s.getNumberOfLibrety(), s.getResidenceCity());
		studentRepository.save(student);
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
