package com.example.demo.DTO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

public class StudentDTO {
	
	private int dni;
	private String names;
	private String lastname;
	private int age;
	private String genre;
	private int numberOfLibrety;
	private String residenceCity;
	private List<CareerStudentDTO> careers;
	
	public StudentDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public StudentDTO(String names, String lastname, int age, String genre, int dni,int numberOfLibrety, String residenceCity, List<CareerStudentDTO> careers) {
		super();
		this.names = names;
		this.lastname = lastname;
		this.age = age;
		this.genre = genre;
		this.dni = dni;
		this.numberOfLibrety = numberOfLibrety;
		this.residenceCity = residenceCity;
		this.careers = careers;
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

	public int getNumberOfLibrety() {
		return numberOfLibrety;
	}

	public void setNumberOfLibrety(int numberOfLibrety) {
		this.numberOfLibrety = numberOfLibrety;
	}

	public List<CareerStudentDTO> getCareers() {
		return careers;
	}

	public void setCareers(List<CareerStudentDTO> careers) {
		this.careers = careers;
	}
	
}
