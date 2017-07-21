package org.altar.upacademy.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name="ORDERS")
public class Order extends Entity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="OrderID")
	private Integer orderId = null;
	
	@OneToOne
	private Client client;
    @OneToOne
    private Seller seller;
    
	@Column(name="Start")
    private int start = 0;
	@Column(name="End")
    private int end = 0;
	@Column(name="Expected_Price")
    private Double expectedPrice = null;
	@Column(name="Delivery")
    private int delivery = 0;
	@Column(name="Delivery_Status")
    private Boolean deliveryStatus = null;
	@Column(name="Final_Price")
    private Double finalPrice = null;
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public Double getExpectedPrice() {
		return expectedPrice;
	}
	public void setExpectedPrice(Double expectedPrice) {
		this.expectedPrice = expectedPrice;
	}
	public int getDelivery() {
		return delivery;
	}
	public void setDelivery(int delivery) {
		this.delivery = delivery;
	}
	public Boolean getDeliveryStatus() {
		return deliveryStatus;
	}
	public void setDeliveryStatus(Boolean deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	public Double getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(Double finalPrice) {
		this.finalPrice = finalPrice;
	}
}
