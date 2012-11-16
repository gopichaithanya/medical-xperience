package controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.Person;

@ManagedBean
@SessionScoped
public class loginController {
	private Person user = new Person();
	
	
	
	public String loginValidator(String username, String password){
		System.out.println(username + " - " + password);
		FacesMessage msg;
		if (verifyUser(username, password)){

			//TODO: Procurar a pessoa na lista e colocar ela na variavel USER
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", user);

			Person logged = (Person) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
			//TODO: utilizar o nome da pessoa e não o usuário
			msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome "+logged.getUser()+"!",null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return "index";
		}else{
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid username or Password!", null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return null;
		}
	}

	public Person getUser() {
		return user;
	}

	public void setUser(Person user) {
		this.user = user;
	}
	
	public boolean verifyUser(String user, String password){
		
		//TODO: Verificação no banco do usuário
		if ((user.equals("admin")) && (password.equals("admin"))){
			return true;
		}else{
			return false;
		}
	}
	
}
