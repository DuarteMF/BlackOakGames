package org.altar.upacademy.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@javax.persistence.Entity
@Table(name="OrderList")
public class Order extends Entity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Order_ID")
	private Integer orderId = null;
	
	@OneToOne
	private Client client;
    @OneToOne
    private Seller seller;
    
	@Column(name="Start_Date")
    private LocalDate start;
	@Column(name="End_Date")
    private LocalDate end;
	@Column(name="Expected_Price")
    private Double expectedPrice = null;
	@Column(name="Delivery_Date")
    private LocalDate delivery;
	@Column(name="Delivery_Status")
    private Boolean deliveryStatus = null;
	@Column(name="Final_Price")
    private Double finalPrice = null;
	
	@OneToMany(targetEntity=ProductUnit.class, fetch=FetchType.EAGER)
	private Set<ProductUnit> productUnitSet;
	
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
	public LocalDate getStart() {
		return start;
	}
	public void setStart(LocalDate start) {
		this.start = start;
	}
	public LocalDate getEnd() {
		return end;
	}
	public void setEnd(LocalDate end) {
		this.end = end;
	}
	public Double getExpectedPrice() {
		return expectedPrice;
	}
	public void setExpectedPrice(Double expectedPrice) {
		this.expectedPrice = expectedPrice;
	}
	public LocalDate getDelivery() {
		return delivery;
	}
	public void setDelivery(LocalDate delivery) {
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
	public Set<ProductUnit> getProductUnitSet() {
		return productUnitSet;
	}
	public void setProductUnitSet(Set<ProductUnit> productUnitSet) {
		this.productUnitSet = productUnitSet;
	}
}
