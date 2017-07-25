package org.altar.upacademy.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="login")
@SessionScoped
public class LoginController implements Serializable{
	
	
	private String username;
	private String password;
	
	
	public String loginControl(){
		return password;
		
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
