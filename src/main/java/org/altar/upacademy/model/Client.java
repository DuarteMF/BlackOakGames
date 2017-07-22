package org.altar.upacademy.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@javax.persistence.Entity
@Table(name="CLIENTS")
public class Client extends Entity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Client_ID")
	private Integer clientId = 0;
	
	@Size(min=2,max=30, message = "Client Name should be between 2 and 30 characters")
	@Column(name="Client_Name", nullable = true, unique = true)
	private String clientName;
	@Column(name="Client_Email")
	private String clientEmail;
	@Column(name="Client_PhoneNumber")
	private long clientPhoneNumber;
	@Column(name="Client_Address")
	private String clientAddress;
	@Column(name="Client_Feedback")
	private double clientFeedback;
	
	
	public Integer getClientId() {
		return clientId;
	}
	public void setClientId(Integer clientId) {
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
	
	@Override
	public String toString(){
		return this.clientName;
	}
	
	@Override
	public boolean equals(Object client){
		return this.clientId.equals(((Client) client).getClientId());
	}
}
