package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="disease")
public class Disease {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String description;
	@OneToMany
	private List<Symptom> listSyptoms = new ArrayList<Symptom>();
	@OneToMany
	private List<Medicine> listMedicine = new ArrayList<Medicine>();
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Symptom> getListSyptoms() {
		return listSyptoms;
	}
	public void setListSyptoms(List<Symptom> listSyptoms) {
		this.listSyptoms = listSyptoms;
	}
	public List<Medicine> getListMedicine() {
		return listMedicine;
	}
	public void setListMedicine(List<Medicine> listMedicine) {
		this.listMedicine = listMedicine;
	}
	
	
	
	
}
