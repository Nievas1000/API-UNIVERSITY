package com.example.demo.serviceImpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.DTO.CareerDTO;
import com.example.demo.DTO.CareerStudentDTO;
import com.example.demo.DTO.InscriptionDTO;
import com.example.demo.DTO.ReportDTO;
import com.example.demo.DTO.StudentDTO;
import com.example.demo.DTO.StudentHistoryDTO;
import com.example.demo.model.Career;
import com.example.demo.model.Student;
import com.example.demo.model.StudentHistory;
import com.example.demo.repository.CareerRepository;
import com.example.demo.repository.StudentHistoryRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentHistoryService;

@Service
public class StudentHistoryServiceImpl implements StudentHistoryService {
		@Autowired
	 	private StudentRepository studentRepository;
		@Autowired
	 	private CareerRepository careerRepository;
		@Autowired
	 	private StudentHistoryRepository studentHistoryRepository;

	@Override
	public void insertStudentToCareer(InscriptionDTO inscription) {
		long miliSeconds = System.currentTimeMillis();
		Date date = new Date(miliSeconds);
		Student student = studentRepository.getStudentByNumberOfLibrety(inscription.getNumberOfLibrety());
		Career career = careerRepository.getCareerById(inscription.getIdCareer());
		studentHistoryRepository.save(new StudentHistory(student, career, date, null, false));
	}
	
	public List<ReportDTO> getReport(){
		List<ReportDTO> report = new ArrayList<>();
		List<Career> careers = studentHistoryRepository.getCareerOrderByName();
		for (Career career : careers) {
			List<StudentDTO> studentsDTO = new ArrayList<>();
			List<Student> students = studentHistoryRepository.getStudentsByCareerAndEgressDate(career.getIdCareer());
			CareerDTO careerDTO = new CareerDTO(career.getName());
			for (Student student : students) {
				List<CareerStudentDTO> careersStudent = new ArrayList<>();
				if(!student.getCareers().isEmpty()) {
					for (StudentHistory sh : student.getCareers()) {
						CareerStudentDTO csDTO = new CareerStudentDTO(sh.getCareer(), sh.getInscriptionDate(), sh.getEgressDate(), sh.isGraduate());
						careersStudent.add(csDTO);
					}
				}
				StudentDTO stu = new StudentDTO(student.getNames(), student.getLastname(), student.getAge(), student.getGenre(), student.getDni(), student.getNumberOfLibrety(), student.getResidenceCity(),careersStudent);
				studentsDTO.add(stu);
			}
			ReportDTO r = new ReportDTO(careerDTO, studentsDTO);
			report.add(r);
		}
		return report;
	}
}
