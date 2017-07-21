package org.altar.upacademy.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@javax.persistence.Entity
@Table(name="SELLERS")
public class Seller extends Entity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer sellerId = 0;
	
	@Size(min=2,max=30, message = "Seller Name should be between 2 and 30 characters")
	@Column(name="Seller_Name", nullable = true, unique = true)
	private String sellerName;
	@Column(name="Seller_Email")
	private String sellerEmail;
	@Column(name="Seller_PhoneNumber")
	private long sellerPhoneNumber;
	@Column(name="Seller_Address")
	private String sellerAddress;
	@Column(name="Seller_Feedback")
	private double sellerFeedback;
	
	public Integer getSellerId() {
		return sellerId;
	}
	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getSellerEmail() {
		return sellerEmail;
	}
	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}
	public long getSellerPhoneNumber() {
		return sellerPhoneNumber;
	}
	public void setSellerPhoneNumber(long sellerPhoneNumber) {
		this.sellerPhoneNumber = sellerPhoneNumber;
	}
	public String getSellerAddress() {
		return sellerAddress;
	}
	public void setSellerAddress(String sellerAddress) {
		this.sellerAddress = sellerAddress;
	}
	public double getSellerFeedback() {
		return sellerFeedback;
	}
	public void setSellerFeedback(double sellerFeedback) {
		this.sellerFeedback = sellerFeedback;
	}
}
