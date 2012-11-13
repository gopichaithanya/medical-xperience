package model;

import javax.persistence.*;

@Entity
@Table(name="symptom")
public class Symptom {
	
	@Id
	@GeneratedValue
	private int id;
	private String symptom;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSymptom() {
		return symptom;
	}
	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}
	
	
}
