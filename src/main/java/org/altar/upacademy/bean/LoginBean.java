package org.altar.upacademy.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;


import org.altar.upacademy.model.Login;
import org.altar.upacademy.model.Platform;
import org.altar.upacademy.repository.LoginRepository;

@Named("LoginBean")
@RequestScoped
public class LoginBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Login newAccount = new Login();

	public Login getNewAccount() {
		return newAccount;
	}

	public void setNewAccount(Login newAccount) {
		this.newAccount = newAccount;
	}
	
	@Inject
	private LoginRepository loginRepository;
	
	public List<Login> getList(){
		return loginRepository.getDbLogin();
	}
	
	
	public void checkAccountName() {
		if(loginRepository.getLoginFromName(newAccount.getUsername()).isEmpty()){
			addAccount();
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!",
					"There is already another person with the same Username "));
		}
	}
	
	@Inject
	private ClientBean clientBean;
	
	public void addAccount() {
		clientBean.addClient();
		newAccount.setClient(clientBean.getAddedClient());
		loginRepository.addToDb(newAccount);
	}
}
