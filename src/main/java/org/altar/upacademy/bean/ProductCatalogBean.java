package org.altar.upacademy.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.altar.upacademy.model.Category;
import org.altar.upacademy.model.Platform;
import org.altar.upacademy.model.Product;
import org.altar.upacademy.model.Category;
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
	
	public void searchBar(){
		
	
// os getters e os setters das variaveis??

//	@Inject
//	private ProductRepository productRepository;
//	
//	public List<Product> getProductList() {
//		return productRepository.getDbProduct();
//	}
//	
//	@Inject
//	private CategoryRepository categoryRepository;
//	
//	public List<Category> getCategoryList() {
//		return categoryRepository.getDbCategories();
//	}
//	
//	@Inject
//	private PlatformRepository platformRepository;
//	
//	public List<Platform> getPlatformList() {
//		return platformRepository.getDbPlatforms();
//	}
	
	
//	public Product searchProduct(){
//		return productRepository.searchFromCatalog();
//	}
	
	}
}