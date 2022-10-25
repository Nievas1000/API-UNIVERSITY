package com.example.demo.DTO;

public class InscriptionDTO {
	
	private int numberOfLibrety;
	private int idCareer;
	public InscriptionDTO(int numberOfLibrety, int idCareer) {
		super();
		this.numberOfLibrety = numberOfLibrety;
		this.idCareer = idCareer;
	}
	
	public int getNumberOfLibrety() {
		return numberOfLibrety;
	}
	public void setNumberOfLibrety(int numberOfLibrety) {
		this.numberOfLibrety = numberOfLibrety;
	}
	public int getIdCareer() {
		return idCareer;
	}
	public void setIdCareer(int idCareer) {
		this.idCareer = idCareer;
	}
	
	

}
