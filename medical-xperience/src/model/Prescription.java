package model;

import javax.persistence.*;


@Entity
@Table(name="prescription")
public class Prescription {
	
	@Id
	@GeneratedValue
	private int id;
	@OneToOne
	private Medicine medicine;
	private String dosage;
	private String period;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Medicine getMedicine() {
		return medicine;
	}
	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	} 
	public String getDosage() {
		return dosage;
	}
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	
}
