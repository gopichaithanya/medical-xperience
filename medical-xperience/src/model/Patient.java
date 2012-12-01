package model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Patient extends Person{
		
	/**
	 * Just how was recommended by Eclipse
	 */
	private static final long serialVersionUID = 1L;
	
	private Date birthDate;

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
}
