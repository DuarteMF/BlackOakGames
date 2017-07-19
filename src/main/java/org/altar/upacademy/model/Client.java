package org.altar.upacademy.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name="CLIENTS")
public class Client extends Entity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int clientId;
	
	private String clientName;
	private String clientEmail;
	private long clientPhoneNumber;
	private String clientAddress;
	private double clientFeedback;
	
	
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientEmail() {
		return clientEmail;
	}
	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}
	public long getClientPhoneNumber() {
		return clientPhoneNumber;
	}
	public void setClientPhoneNumber(long clientPhoneNumber) {
		this.clientPhoneNumber = clientPhoneNumber;
	}
	public String getClientAddress() {
		return clientAddress;
	}
	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}
	public double getClientFeedback() {
		return clientFeedback;
	}
	public void setClientFeedback(double clientFeedback) {
		this.clientFeedback = clientFeedback;
	}
}
