package view;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import model.Patient;
import model.PersonDAO;

/**
 * Class converter to use in auto-populated dropdown (Primefaces requisite)
 * @author Ricardo
 *
 */
@FacesConverter(value = "PatientConverter") 
public class PatientConverter implements Converter{

	/**
	 * Implementation of Converter. Using a string, search an object
	 * @returns Object relationed with string
	 */
	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		
		if ((value != null) && (value != "")){
			int ID = Integer.parseInt(value);
			return PersonDAO.getPatient(ID);
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
		if ((value != null) && (value instanceof Patient)){
			Patient p = (Patient) value;
			return String.valueOf(p.getId());
		} else {
			return null;
		}
	}
	

}
