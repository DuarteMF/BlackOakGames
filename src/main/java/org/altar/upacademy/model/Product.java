package org.altar.upacademy.model;

import java.io.Serializable;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@javax.persistence.Entity
@Table(name="PRODUCT")
@ManagedBean

public class Product extends Entity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Product_ID")
	private Integer productId = 0;
	@Size(min=2,max=30, message = "Product Name should be between 2 and 30 characters")
	@Column(name="Product_Name", nullable = true, unique = true)
	private String productName = null;
	@Min(1980) @Max(2018)
	@Column(name="Year")
	private Integer year = null;
	@Size(min=2,max=30, message = "Publisher Name should be between 2 and 30 characters")
	@Column(name="Publisher")
	private String publisher = null;
	@Size(min=2,max=1000, message = "Should not exceed 1000 characters")
	@Column(name="Details")
	private String details = null;
	@DecimalMax(value= "35.00", message = "Should not exceed 35.00€")
	@Column(name="Rental_Price")
	private Double rentalPrice = null;
	@Max(99)
	@Column(name="Availability")
	private Integer availability = null;
	@Column(name="Product_Image")
	private String productImageName = null;
	@Column(name="Product_Video")
	private String productVideoUrl = null;
	
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
	public Double getRentalPrice() {
		return rentalPrice;
	}
	public void setRentalPrice(Double rentalPrice) {
		this.rentalPrice = rentalPrice;
	}
	public Integer getAvailability() {
		return availability;
	}
	public void setAvailability(Integer availability) {
		this.availability = availability;
	}
	
	public String getProductImageName() {
		return productImageName;
	}
	public void setProductImageName(String productImageName) {
		this.productImageName = productImageName;
	}
	public String getProductVideoUrl() {
		return productVideoUrl;
	}
	public void setProductVideoUrl(String productVideoUrl) {
		this.productVideoUrl = productVideoUrl;
	}
	public Product() {

	}
	
	@ManyToMany(targetEntity=Platform.class, fetch=FetchType.EAGER)
	private Set<Platform> platformSet;

	public Set<Platform> getPlatformSet() {
		return platformSet;
	}
	public void setPlatformSet(Set<Platform> platformSet) {
		this.platformSet = platformSet;
	}
	
	@ManyToMany(targetEntity=Category.class, fetch=FetchType.EAGER)
	private Set<Category> categorySet;

	public Set<Category> getCategorySet() {
		return categorySet;
	}
	public void setCategorySet(Set<Category> categorySet) {
		this.categorySet = categorySet;
	}
	
	@Override
	public String toString(){
		return this.productName;
	}
	
	@Override
	public boolean equals(Object product){
		return this.productId.equals(((Product) product).getProductId());
	}
	
}