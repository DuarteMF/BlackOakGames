package org.altar.upacademy.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.altar.upacademy.model.Category;
import org.altar.upacademy.model.Platform;
import org.altar.upacademy.repository.CategoryRepository;
import org.altar.upacademy.repository.PlatformRepository;
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
		System.out.println(searchProduct);
		this.searchProduct = searchProduct;
	}

	public Integer getSearchCategory() {
		return searchCategory;
	}

	public void setSearchCategory(Integer searchCategory) {
		System.out.println(searchCategory);
		this.searchCategory = searchCategory;
	}

	public Integer getSearchPlatform() {
		return searchPlatform;
	}

	public void setSearchPlatform(Integer searchPlatform) {
		System.out.println(searchPlatform);
		this.searchPlatform = searchPlatform;
	}

	@Inject
	private ProductRepository productRepository;
	
	public void searchBar(){
		productRepository.searchFromCatalog(searchProduct, searchCategory, searchPlatform);
	}
	
	@Inject
	private CategoryRepository categoryRepository;
	
	@Inject
	private PlatformRepository platformRepository;
	
//	public void searchBar(){
//		Category category = (Category) categoryRepository.readFromDb(searchCategory);
//		Platform platform = (Platform) platformRepository.readFromDb(searchPlatform);
//		productRepository.searchFromCatalog(searchProduct, category, platform);
//	}
}