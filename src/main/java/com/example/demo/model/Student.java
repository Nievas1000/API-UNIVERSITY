package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Student {
	@Id
	private int dni;
	@Column
	private String names;
	@Column
	private String lastname;
	@Column
	private int age;
	@Column
	private String genre;
	@Column(name = "numberOfLibrety")
	private int numberOfLibrety;
	@Column
	private String residenceCity;
	@JsonManagedReference
	@OneToMany(mappedBy = "student")
	private List<StudentHistory> careers;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(String names, String lastname, int age, String genre, int dni,int numberOfLibrety, String residenceCity) {
		super();
		this.names = names;
		this.lastname = lastname;
		this.age = age;
		this.genre = genre;
		this.dni = dni;
		this.numberOfLibrety = numberOfLibrety;
		this.residenceCity = residenceCity;
		this.careers = new ArrayList<>();
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getResidenceCity() {
		return residenceCity;
	}

	public void setResidenceCity(String residenceCity) {
		this.residenceCity = residenceCity;
	}

	public List<StudentHistory> getCareers() {
		return careers;
	}
	
	public int getNumberOfLibrety() {
		return numberOfLibrety;
	}

	public void setNumberOfLibrety(int numberOfLibrety) {
		this.numberOfLibrety = numberOfLibrety;
	}

	@Override
	public String toString() {
		return "\nName: "+this.names+
				"\nLastname: "+this.lastname+
				"\nAge: "+this.age+
				"\nGenre: "+this.dni+
				"\nLibrety of student: "+this.numberOfLibrety+
				"\nResidence city: "+this.residenceCity;
	}
	
}
