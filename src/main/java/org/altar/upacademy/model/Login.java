package org.altar.upacademy.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@javax.persistence.Entity
@Table(name = "LOGIN")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Login.control", query = "SELECT l FROM Login l WHERE l.username = :username and l.password = :password"),
	@NamedQuery(name = "Login.findAll", query = "SELECT l FROM Login l"),
	@NamedQuery(name = "Login.findById", query = "SELECT l FROM Login l WHERE l.loginId = :loginId"),
	@NamedQuery(name = "Login.findByUsername", query ="SELECT l FROM Login l WHERE l.username = :username"),
	@NamedQuery(name = "Login.findByPassword", query = "SELECT l FROM Login l WHERE l.password = :password")
})
public class Login extends Entity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Login_Id")
	private Integer loginId;
	@Column(name = "Username")
	private String username;
	@Column(name= "Password")
	private String password;
	
	
	public Integer getLoginId() {
		return loginId;
	}
	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
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

