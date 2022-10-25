package com.example.demo.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.example.demo.DTO.StudentHistoryDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class StudentHistory{
	
	@EmbeddedId
	private StudentHistoryDTO id;
	
	@JsonManagedReference
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("dni_student")
	@JoinColumn(name="dni_student")
	private Student student;
	@JsonManagedReference
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("id_career")
	@JoinColumn(name="id_career", referencedColumnName = "id")
	private Career career;
	@Column(nullable = false)
	private Date inscriptionDate;
	@Column(nullable = true)
	private Date egressDate;
	@Column
	private boolean graduate;
	
	public StudentHistory() {
		// TODO Auto-generated constructor stub
	}

	public StudentHistory(Student student, Career career, Date inscriptionDate, Date egressDate,
			boolean graduate) {
		super();
		this.id = new StudentHistoryDTO(student.getDni(), career.getIdCareer());
		this.student = student;
		this.career = career;
		this.inscriptionDate = inscriptionDate;
		this.egressDate = egressDate;
		this.graduate = graduate;
	}

	public String getStudent() {
		return student.getLastname() + " "+student.getNames();
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getCareer() {
		return career.getName();
	}

	public void setCareer(Career career) {
		this.career = career;
	}

	public boolean isGraduate() {
		return graduate;
	}

	public void setGraduate(boolean graduate) {
		this.graduate = graduate;
	}
	
	public Date getInscriptionDate() {
		return inscriptionDate;
	}

	public void setInscriptionDate(Date inscriptionDate) {
		this.inscriptionDate = inscriptionDate;
	}

	public Date getEgressDate() {
		return egressDate;
	}

	public void setEgressDate(Date egressDate) {
		this.egressDate = egressDate;
	}

	@Override
	public String toString() {
		return "Student: "+student.getLastname()+
				"\nCareer: "+career.getName();
	}

	
	@Override
	public int hashCode() {
		return student.getDni();
	}
	
}
