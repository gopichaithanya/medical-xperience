package controller;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import util.ClassTranslation;

import model.Doctor;
import model.Employee;
import model.Patient;
import model.PersonDAO;
import model.Person;

@ManagedBean
@SessionScoped
public class UserController{
	

	
	
	private Person person = new Person();
	private String userType;
	
	public List<Person> list(){
		return PersonDAO.list();
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	public String editUser (Person p){
		this.person = p;
		return "editUser";
	}
	
	public String deleteUser (Person p, Person currentUser){
		PersonDAO.remove(p);
		//TODO LOG THE USER ACTIVITY
		//ApplicationLogDAO.createLog("PatientList", user, "127.0.0.1", "Patient Deleted", "The user "+p.getUser()+" has been deleted!", 3);
		return "userList";
	}
	
	public String updateUser(){
		PersonDAO.update(this.person);
		return "userList";
	}
	
	public String newUserScreen() {
		this.person = new Person();
		return "newUser";
	}
	
	/**
	 * Create new user on database baseed on type of user.
	 * @return Redirect to user list
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public String newUser() throws IllegalAccessException, InvocationTargetException{
		if (this.userType.matches("doctor")){
			Doctor d = ClassTranslation.toDoctor(this.person);
			PersonDAO.save(d);
		}else if (this.userType.matches("employee")){
			Employee e = ClassTranslation.toEmployee(this.person);
			PersonDAO.save(e);
		}else if (this.userType.matches("patient")){
			Patient p = ClassTranslation.toPatient(this.person);
			PersonDAO.save(p);
		}
		return "userList";
	}

	
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	
}
