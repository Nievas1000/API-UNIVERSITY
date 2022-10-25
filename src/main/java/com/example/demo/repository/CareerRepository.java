package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Career;
import com.example.demo.model.Student;

@Repository
public interface CareerRepository extends JpaRepository<Career, Long> {
	
	@Query("SELECT c FROM StudentHistory s JOIN s.career c  GROUP BY c ORDER BY COUNT(c) DESC")
	public List<Career> getCareersByNumberOfStudents();
	
	@Query("SELECT s FROM StudentHistory sh JOIN sh.student s WHERE sh.career.id = :id ORDER BY s.residenceCity")
	public List<Student> getStudentsByCareerCity(int id);
	
	@Query("SELECT c FROM StudentHistory sr JOIN sr.career c GROUP BY c.id ORDER BY c.name")
	public List<Career> getCareersByOrder();
	
	@Query("SELECT s FROM StudentHistory sr JOIN sr.student s WHERE sr.career.id = :id ORDER BY sr.egressDate")
	public List<Student> getStudentByCareerByEgressDate(int id);
	
	@Query("SELECT c FROM Career c WHERE c.id = :id")
	public Career getCareerById(int id);

}
