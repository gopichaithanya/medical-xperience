package controller;


import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.Appointment;
import model.AppointmentDAO;

@ManagedBean
@SessionScoped
public class AppointmentController{
	private Appointment appoitment = new Appointment();
	
	public String saveAppointment(){
		AppointmentDAO.saveNew(appoitment);
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Appointment Created!", null);
		FacesContext.getCurrentInstance().addMessage(null, msg);
		this.appoitment = new Appointment();
		return "schedule";
	}
	
	public String updateAppointment(){
		AppointmentDAO.update(this.appoitment);
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Appointment Saved!", null);
		FacesContext.getCurrentInstance().addMessage(null, msg);
		this.appoitment = new Appointment();
		return "schedule";
	}
	
	
	public List<Appointment> list(){
		return AppointmentDAO.list();
	}

	public Appointment getAppoitment() {
		return appoitment;
	}

	public void setAppoitment(Appointment appoitment) {
		this.appoitment = appoitment;
	}
	
	public String editAppointment(Appointment a){
		this.appoitment = a;
		return "editAppointment";
	}

	
	
}
