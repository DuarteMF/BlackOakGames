package org.altar.upacademy.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name="PRODUCT_UNITS")
public class ProductUnit extends Entity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer productUnitId;
	
	@ManyToOne
	private Product product;
	
	@ManyToOne
	private Platform productPlatform;
	
	@Column(name = "Available")
	private boolean available = true;

	public Integer getProductUnitId() {
		return productUnitId;
	}

	public void setProductUnitId(Integer productUnitId) {
		this.productUnitId = productUnitId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Platform getProductPlatform() {
		return productPlatform;
	}

	public void setProductPlatform(Platform productPlatform) {
		this.productPlatform = productPlatform;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	@Override
	public String toString(){
		return this.product.getProductName();
	}
	
	@Override
	public boolean equals(Object productUnit){
		return this.productUnitId.equals(((ProductUnit) productUnit).getProductUnitId());
	}
}
