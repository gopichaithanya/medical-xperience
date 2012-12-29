package util;

import model.Doctor;
import model.Employee;
import model.Patient;
import model.Person;


/**
 * Class used to convert between Person and their childrens
 * @author Ricardo
 *
 */
public class ClassTranslation {
	
	/**
	 * Convert a Person to a Doctor
	 * @param p Person to be converted
	 * @return Doctor from conversion
	 */
	public static Doctor toDoctor (Person p){
		Doctor d = new Doctor();
		d.setCpf(p.getCpf());
		d.setEmail(p.getEmail());
		d.setFirstName(p.getFirstName());
		d.setId(p.getId());
		d.setLastName(p.getLastName());
		d.setPassword(p.getPassword());
		d.setPermission(p.getPermission());
		d.setPhone(p.getPhone());
		d.setUser(p.getUser());
		return d;
	}
	
	
	/**
	 * Convert a Person to an Employee
	 * @param p Person to be converted
	 * @return Employee from conversion
	 */
	public static Employee toEmployee (Person p){
		Employee d = new Employee();
		d.setCpf(p.getCpf());
		d.setEmail(p.getEmail());
		d.setFirstName(p.getFirstName());
		d.setId(p.getId());
		d.setLastName(p.getLastName());
		d.setPassword(p.getPassword());
		d.setPermission(p.getPermission());
		d.setPhone(p.getPhone());
		d.setUser(p.getUser());
		return d;
	}
	
	/**
	 * Convert a Person to an Patient
	 * @param p Person to be converted
	 * @return Patient from conversion
	 */
	public static Patient toPatient (Person p){
		Patient d = new Patient();
		d.setCpf(p.getCpf());
		d.setEmail(p.getEmail());
		d.setFirstName(p.getFirstName());
		d.setId(p.getId());
		d.setLastName(p.getLastName());
		d.setPassword(p.getPassword());
		d.setPermission(p.getPermission());
		d.setPhone(p.getPhone());
		d.setUser(p.getUser());
		return d;
	}
}
