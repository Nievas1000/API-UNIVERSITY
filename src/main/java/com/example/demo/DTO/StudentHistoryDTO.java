package com.example.demo.DTO;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Embeddable
public class StudentHistoryDTO implements Serializable{
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "dni_student")
	private long studentDNI;
	@Column(name = "id_career")
    private long careerId;
	
	
	public StudentHistoryDTO() {
		// TODO Auto-generated constructor stub
	}

    public StudentHistoryDTO(long studentDNI, long careerId) {
		super();
		this.studentDNI = studentDNI;
		this.careerId = careerId;
	}

	public long getStudenDNI() {
        return studentDNI;
    }

    public long getCareerId() {
        return careerId;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(studentDNI, careerId);
    }

}
