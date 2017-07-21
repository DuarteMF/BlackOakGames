package org.altar.upacademy.model;

import java.io.Serializable;

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
	private int productUnitId;
	
	@ManyToOne
	private Product product;
	
	@ManyToOne
	private Platform productPlatform;

	public int getProductUnitId() {
		return productUnitId;
	}

	public void setProductUnitId(int productUnitId) {
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

}
