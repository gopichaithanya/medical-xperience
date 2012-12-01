package model;



import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;


import util.HibernateUtil;

public class AppointmentDAO {

	public static void save(Appointment ap){
		Session session =  HibernateUtil.getSession().getCurrentSession();
		session.save(ap);
	}
	
	public static void saveNew(Appointment ap){
		Session session =  HibernateUtil.getSession().getCurrentSession();
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession httpsession = (HttpSession) fc.getExternalContext().getSession(false);
		int id = Integer.parseInt(httpsession.getAttribute("USERID").toString());
		ap.setApprover(PersonDAO.getPerson(id));
		session.save(ap);
	}
	
	public static void update(Appointment ap){
		Session session =  HibernateUtil.getSession().getCurrentSession();
		session.update(ap);
	}
	
	public static List<Appointment> list(){
		Session session =  HibernateUtil.getSession().getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Appointment> list = (List<Appointment>) session.createCriteria(Appointment.class).list();
		return list;
	}
}
