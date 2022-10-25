package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Career;
import com.example.demo.model.Student;
import com.example.demo.model.StudentHistory;

@Repository
public interface StudentHistoryRepository extends JpaRepository<StudentHistory, Long> {
	
	@Query("SELECT c FROM StudentHistory sr JOIN sr.career c GROUP BY c.id ORDER BY c.name")
	public List<Career> getCareerOrderByName();
	
	@Query("SELECT s FROM StudentHistory sr JOIN sr.student s WHERE sr.career.id = :career ORDER BY sr.egressDate")
	public List<Student> getStudentsByCareerAndEgressDate(int career);

}
