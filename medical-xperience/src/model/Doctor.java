package model;

import javax.persistence.*;

@Entity
public class Doctor extends Person {
	
	/**
	 * Just how was recommended by eclipse
	 */
	private static final long serialVersionUID = 1L;
	
	private String CRM;
	private String speciality;
	public String getCRM() {
		return CRM;
	}
	public void setCRM(String cRM) {
		CRM = cRM;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	
	
}
