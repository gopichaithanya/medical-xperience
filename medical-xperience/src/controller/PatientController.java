package controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import model.Patient;
import model.PersonDAO;

@ManagedBean
@SessionScoped
public class PatientController {
	private Patient patient = new Patient();

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public String createPatient(){
		PersonDAO.save(this.patient);
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Patient Created!", null);
		FacesContext.getCurrentInstance().addMessage(null, msg);
		return "patientList";
	}
	
	public String updatePatient(){
		PersonDAO.update(this.patient);
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Patient Updated!", null);
		FacesContext.getCurrentInstance().addMessage(null, msg);
		return "patientList";
	}
	
	public String editExistingPatient(Patient p){
		System.out.println("OLA!");
		this.patient = p;
		return "editPatient";
	}
	
	public String newPatientScreen(){
		this.patient = new Patient();
		return "newPatient";
	}
	
	public List<Patient> listPatient(){
		return PersonDAO.listPatient();
	}
	
	
	public static String deletePatient(Patient p, String user){
		PersonDAO.remove(p);
		//TODO: Use the logger;
		//ApplicationLogDAO.createLog("PatientList", user, "127.0.0.1", "Patient Deleted", "The user "+p.getUser()+" has been deleted!", 3);
		return "patientList";
	}
}
