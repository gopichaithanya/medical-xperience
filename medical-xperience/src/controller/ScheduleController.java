package controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.ScheduleEntrySelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;


import model.Appointment;
import model.AppointmentDAO;

@ManagedBean
@SessionScoped
public class ScheduleController {
	private List<Appointment> appoitmentList = new ArrayList<Appointment>();
	private ScheduleModel eventList = new DefaultScheduleModel();
	private ScheduleEvent event = new DefaultScheduleEvent();

	
	
	public List<Appointment> getAppoitmentList() {
		return appoitmentList;
	}



	public void setAppoitmentList(List<Appointment> appoitmentList) {
		this.appoitmentList = appoitmentList;
	}



	public ScheduleModel getEventList() {
		return eventList;
	}



	public void setEventList(ScheduleModel eventList) {
		this.eventList = eventList;
	}



	public ScheduleEvent getEvent() {
		return event;
	}



	public void setEvent(ScheduleEvent event) {
		this.event = event;
	}

	public ScheduleModel list(){
		appoitmentList = AppointmentDAO.list();
		
		// Translate the Appointments in Events
		if (eventList.getEventCount() == 0){
			//eventList.clear();
			for (Iterator<Appointment> i = appoitmentList.iterator(); i.hasNext();){
				Appointment a = i.next();
				event = new DefaultScheduleEvent(a.getPatient().getFirstName()+" "+a.getPatient().getLastName(),
						a.getDate(), a.getDate(), a);
				eventList.addEvent(event);
			}
		}
		return eventList;
	}


	public void onEventSelect(ScheduleEntrySelectEvent selectEvent) throws IOException {  
		event = selectEvent.getScheduleEvent();
		Appointment a = (Appointment) event.getData();
		
		//Getting the current instance of Appoitment Controller
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		AppointmentController ac = (AppointmentController) FacesContext.getCurrentInstance().getApplication().getELResolver().getValue(elContext, null, "appointmentController");
		ac.editAppointment(a);
		//Redirecting to edit page
		FacesContext.getCurrentInstance().getExternalContext().redirect("editAppointment.jsf");
	}
	
	/**
	 * Refreshes the Appoitment Schedule
	 * @return Redirect to page "schedule"
	 */
	public String refreshSchedule(){
		appoitmentList = AppointmentDAO.list();
		//Clearing the eventList	
		eventList.clear();
		// Regenerating the events baseed on appoitments
		for (Iterator<Appointment> i = appoitmentList.iterator(); i.hasNext();){
				Appointment a = i.next();
				event = new DefaultScheduleEvent(a.getPatient().getFirstName()+" "+a.getPatient().getLastName(),
						a.getDate(), a.getDate(), a);
				eventList.addEvent(event);
		}
		return "schedule";
	}
	
	
}
