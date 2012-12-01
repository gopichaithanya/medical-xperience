package view;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import model.Doctor;
import model.PersonDAO;

/**
 * Class converter to use in auto-populated dropdown (Primefaces requisite)
 * @author Ricardo
 *
 */
@FacesConverter(value = "DoctorConverter") 
public class DoctorConverter implements Converter{

	/**
	 * Implementation of Converter. Using a string, search an object
	 * @returns Object relationed with string
	 */
	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		
		if ((value != null) && (value != "")){
			int ID = Integer.parseInt(value);
			return PersonDAO.getDoctor(ID);
		} else {
			return null;
		}
	}

	/**
	 * Default from converter interface
	 * @return String from a object
	 */
	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if ((value != null) && (value instanceof Doctor)){
			Doctor d = (Doctor) value;
			return String.valueOf(d.getId());
		} else {
			return null;
		}
	}
	

}
