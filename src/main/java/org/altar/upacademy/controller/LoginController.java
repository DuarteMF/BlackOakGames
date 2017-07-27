package org.altar.upacademy.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.altar.upacademy.query.DataQuery;
import org.primefaces.context.RequestContext;

@ManagedBean(name="login")
@SessionScoped
public class LoginController implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	private String username = null;
	private String password = null;
	@Inject
	private DataQuery query = new DataQuery();
	
	public String loginControl(){
		if(query.loginControl(username, password)){
			return "dashboard.xhtml";
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
	
	
}
