package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="appointment")
public class Appointment {

	@Id
	@GeneratedValue
	private int id;
	private Date date;
	@OneToOne
	private Patient patient;
	@OneToOne
	private Doctor doctor;
	@OneToOne
	private Person approver;
	private String comments;
	
	@OneToMany
	private List<Symptom> listSymptoms = new ArrayList<Symptom>();
	@OneToMany
	private List<Prescription> listPrescription = new ArrayList<Prescription>();
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Person getApprover() {
		return approver;
	}
	public void setApprover(Person approver) {
		this.approver = approver;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
	public List<Symptom> getListSymptoms() {
		return listSymptoms;
	}
	public void setListSymptoms(List<Symptom> listSymptoms) {
		this.listSymptoms = listSymptoms;
	}
	public List<Prescription> getListPrescription() {
		return listPrescription;
	}
	public void setListPrescription(List<Prescription> listPrescription) {
		this.listPrescription = listPrescription;
	}
	
	
	
}
