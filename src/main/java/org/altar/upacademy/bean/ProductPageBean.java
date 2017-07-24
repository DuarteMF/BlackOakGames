package org.altar.upacademy.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
import javax.inject.Named;

import org.altar.upacademy.model.Product;
import org.altar.upacademy.repository.ProductRepository;

@Named("ProductPageBean")
@RequestScoped
public class ProductPageBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty("#(param.productId)")
	private Integer productId = null;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	@Inject
	private ProductRepository productRepository;
	
	public Product getProduct(){
		return productRepository.getProductFromId(productId);
	}
}
