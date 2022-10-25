package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Career {
	@Id
	private int id;
	@Column
	private String name;
	@JsonManagedReference
	@OneToMany(mappedBy = "career")
	private List<StudentHistory> students;
	
	public Career() {
		// TODO Auto-generated constructor stub
	}

	public Career(int idCareer,String name) {
		super();
		this.id = idCareer;
		this.name = name;
		this.students = new ArrayList<>();
	}

	public int getIdCareer() {
		return id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public List<StudentHistory> getStudents() {
		return students;
	}
	
	
	@Override
	public String toString() {
		return "\nCareer: "+name;
	}
}
