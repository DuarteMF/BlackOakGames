package org.altar.upacademy.bean;

import java.io.Serializable;
import java.util.List;

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
	private Integer searchCategory = null;
	private Integer searchPlatform = null;
	
	
	public String getSearchProduct() {
		return searchProduct;
	}
	
	public void setSearchProduct(String searchProduct) {
		this.searchProduct = searchProduct;
	}

	public Integer getSearchCategory() {
		return searchCategory;
	}

	public void setSearchCategory(Integer searchCategory) {
		this.searchCategory = searchCategory;
	}

	public Integer getSearchPlatform() {
		return searchPlatform;
	}

	public void setSearchPlatform(Integer searchPlatform) {
		this.searchPlatform = searchPlatform;
	}

	@Inject
	private ProductRepository productRepository;
	
	public List<Product> searchBar(){
		return productRepository.searchFromCatalog(searchProduct, searchCategory, searchPlatform);
	}
	
	public String submitSearch(){
		return "success";
	}
}