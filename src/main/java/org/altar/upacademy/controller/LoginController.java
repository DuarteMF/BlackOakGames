package org.altar.upacademy.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.altar.upacademy.model.Login;
import org.altar.upacademy.query.DataQuery;
import org.primefaces.context.RequestContext;

//@ManagedBean(name="login")
@Named("login")
@SessionScoped
public class LoginController implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	private String username = null;
	private String password = null;
	
	private Login activeUser = null;
	
	@Inject
	private DataQuery query = new DataQuery();
	
	public String loginControl(){
		if(query.loginControl(username, password)){
			activeUser = query.getUser(username, password);
			return "index.xhtml?faces-redirect=true";
		}
		RequestContext.getCurrentInstance().update("growl");
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "Username or Password invalid!"));
		return "";
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Login getActiveUser() {
		return activeUser;
	}

	public void setActiveUser(Login activeUser) {
		this.activeUser = activeUser;
	}
	
	public void logout(){
		activeUser = null;
	}
}
