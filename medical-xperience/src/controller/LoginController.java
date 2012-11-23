package controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.LoginHistoryDAO;
import model.Person;
import model.PersonDAO;

@ManagedBean
@SessionScoped
public class LoginController {
	private Person user = new Person();
	private boolean Logged = false;
		
	/**
	 * Method used on loginAction.
	 * This Method use an method to verify the login and baseed on this return a message and put the user on a session.
	 * @param username username to be validated
	 * @param password password to be validated
	 * @return String to next page
	 */
	public String loginValidator(String username, String password){
		FacesMessage msg;
		user = PersonDAO.validateLogin(username, password);
		
		if (user != null){
			// puts the user in the session
			FacesContext fc = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
			session.setAttribute("USERID", user.getId());
			
			// Prints a login message
			msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome "+user.getFirstName()+"!",null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			
			// sets the flag
			this.setLogged(true);
			
			// store the login data
			HttpServletRequest request = (HttpServletRequest) fc.getExternalContext().getRequest();
			LoginHistoryDAO.newLogin(user.getUser(), request.getRemoteAddr());
			
			
			return "index";
		}else{
			// prints a error message, user/password unknown
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid username or Password!", null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			this.user = new Person();
			this.setLogged(false);
			return null;
		}
	}

	public Person getUser() {
		return user;
	}

	public void setUser(Person user) {
		this.user = user;
	}
	
	public static String logout(LoginController current) throws Throwable {
		
		//TODO: Collect the correct IP data
		// store the logoff data
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) fc.getExternalContext().getRequest();
		LoginHistoryDAO.newLogoff(current.user.getUser(), request.getRemoteAddr());

		// Reseting the session user
		current.user = new Person();
		current.setLogged(false);
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		session.removeAttribute("USERID");

		// Send a Logoff Message
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "You Logged Off", null);
		FacesContext.getCurrentInstance().addMessage(null, msg);

		// Returning to login page
		return "login";
	}
	
	/**
	 * Test if some user is logged in.
	 * @param request HttpServletRequest that contains the user action
	 * @return True = User is logged; False = Not logged;
	 */
	public static boolean isLogged(HttpServletRequest request) {
		HttpSession session = (HttpSession) request.getSession();
		if (session.getAttribute("USERID") == null){
			return false;
		} else {
			return true;
		}
	}

	public boolean Logged() {
		return Logged;
	}

	public void setLogged(boolean Logged) {
		this.Logged = Logged;
	}
		
		
	
}
