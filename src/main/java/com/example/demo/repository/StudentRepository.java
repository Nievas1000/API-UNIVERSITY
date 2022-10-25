package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.StudentDTO;
import com.example.demo.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	@Query("SELECT s FROM Student s WHERE s.numberOfLibrety = :number")
	public Student getStudentByNumberOfLibrety(int number);
	
	@Query("SELECT s FROM Student s ORDER BY s.lastname")
	public List<Student> getStudentsBySimpleOrdering();
	
	@Query("SELECT s FROM Student s WHERE s.genre = :genre")
	public List<Student> getStudentsByGenre(String genre);
}
