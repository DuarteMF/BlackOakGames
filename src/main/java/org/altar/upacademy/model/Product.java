package org.altar.upacademy.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name="PRODUCT")

public class Product extends Entity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Product_ID")
	private Integer productId = 0;
	@Column(name="Product_Name", nullable = true)
	private String productName = "produto";
//	@Column(name="Category_ID")
//	private Integer categoryId = 0;
	@Column(name="Year")
	private Integer year = 0000;
	@Column(name="Publisher")
	private String publisher = "produtor";
	@Column(name="Details")
	private String details = "descrição";
	@Column(name="Rental_Price")
	private double rentalPrice = 0.0;
	@Column(name="Availability")
	private Integer availability = 0;
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
//	public Integer getCategoryId() {
//		return categoryId;
//	}
//	public void setCategoryId(Integer categoryId) {
//		this.categoryId = categoryId;
//	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public double getRentalPrice() {
		return rentalPrice;
	}
	public void setRentalPrice(double rentalPrice) {
		this.rentalPrice = rentalPrice;
	}
	public Integer getAvailability() {
		return availability;
	}
	public void setAvailability(Integer availability) {
		this.availability = availability;
	}
	
	public Product() {

	}
	
	@ManyToMany(targetEntity=Platform.class)
	private Set<Platform> platformSet;

	public Set<Platform> getPlatformSet() {
		return platformSet;
	}
	public void setPlatformSet(Set<Platform> platformSet) {
		this.platformSet = platformSet;
	}
	
	@ManyToMany(targetEntity=Category.class)
	private Set<Category> categorySet;

	public Set<Category> getCategorySet() {
		return categorySet;
	}
	public void setCategorySet(Set<Category> categorySet) {
		this.categorySet = categorySet;
	}
	
}