package com.example.demo.DTO;

import java.sql.Date;

public class CareerStudentDTO {
	
	private String name;
	private Date inscriptionDate;
	private Date egressDate;
	private boolean graduated;
	public CareerStudentDTO(String name,Date inscriptionDate, Date egressDate, boolean graduated) {
		super();
		this.name = name;
		this.inscriptionDate = inscriptionDate;
		this.egressDate = egressDate;
		this.graduated = graduated;
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
	public boolean isGraduated() {
		return graduated;
	}
	public void setGraduated(boolean graduated) {
		this.graduated = graduated;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
