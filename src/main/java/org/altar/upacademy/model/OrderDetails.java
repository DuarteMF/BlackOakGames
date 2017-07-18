package org.altar.upacademy.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name="ORDERDETAILS")
public class OrderDetails extends Entity implements Serializable {

	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Order_Details_ID")
    private int orderDetailsId = 0;
    @Column(name="Product_Unit_ID")
    private int productunitId = 0;
	@Column(name="Start")
    private int start = 0;
	@Column(name="End")
    private int end = 0;
	@Column(name="Expected_Price")
    private Double expectedprice = null;
	@Column(name="Delivery")
    private int delivery = 0;
	@Column(name="Delivery_Status")
    private Boolean deliverystatus = null;
	@Column(name="Final_Price")
    private Double finalprice = null;
	public int getOrderDetailsId() {
		return orderDetailsId;
	}
	public void setOrderDetailsId(int orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
	}
	public int getProductunitId() {
		return productunitId;
	}
	public void setProductunitId(int productunitId) {
		this.productunitId = productunitId;
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
	public Double getExpectedprice() {
		return expectedprice;
	}
	public void setExpectedprice(Double expectedprice) {
		this.expectedprice = expectedprice;
	}
	public int getDelivery() {
		return delivery;
	}
	public void setDelivery(int delivery) {
		this.delivery = delivery;
	}
	public Boolean isDeliverystatus() {
		return deliverystatus;
	}
	public void setDeliverystatus(Boolean deliverystatus) {
		this.deliverystatus = deliverystatus;
	}
	public Double getFinalprice() {
		return finalprice;
	}
	public void setFinalprice(Double finalprice) {
		this.finalprice = finalprice;
	}



}
