package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.PersonDAO;
import model.Doctor;

@ManagedBean
@SessionScoped
public class DoctorController {
	
	public List<Doctor> listDoctors(){
		return PersonDAO.listDoctor();
	}
	
}
