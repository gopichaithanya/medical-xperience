package model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Employee extends Person {
	
	/**
	 * Just how was recommended by eclipse
	 */
	private static final long serialVersionUID = 1L;
	private Date admissionDate;
	private String position;
	private String shift;
	
	public Date getAdmissionDate() {
		return admissionDate;
	}
	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getShift() {
		return shift;
	}
	public void setShift(String shift) {
		this.shift = shift;
	}
	
	
}
