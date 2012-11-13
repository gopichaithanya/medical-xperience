package model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Patient extends Person {
	
	private Date birthDate;

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
}
