package org.altar.upacademy.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.altar.upacademy.model.Product;
import org.altar.upacademy.repository.ProductRepository;

@Named("ProductPageBean")
@RequestScoped
public class ProductPageBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer productId = null;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	@Inject
	private ProductRepository productRepository;
	
	private Product product;
	
	public Product getProduct(){
		return this.product;
	}
	
	public void setProduct(){
		this.product = productRepository.getProductFromId(productId);
	}
}
