package org.altar.upacademy.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.altar.upacademy.model.Product;
import org.altar.upacademy.repository.ProductRepository;

@Named("ProductCatalogBean") 
@RequestScoped
public class ProductCatalogBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String searchProduct = null;
	private Integer categoryId = null;
	private Integer platformId = null;
	
	public String getSearchProduct() {
		return searchProduct;
	}

	public void setSearchProduct(String searchProduct) {
		this.searchProduct = searchProduct;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getPlatformId() {
		return platformId;
	}

	public void setPlatformId(Integer platformId) {
		this.platformId = platformId;
	}

	@Inject
	private ProductRepository productRepository;
	
	public Product searchProduct(){
		return productRepository.searchProductFromCatalog();
	}
	
}
