package org.altar.upacademy.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.altar.upacademy.model.Category;
import org.altar.upacademy.model.Platform;
import org.altar.upacademy.model.Product;
import org.altar.upacademy.repository.CategoryRepository;
import org.altar.upacademy.repository.PlatformRepository;
import org.altar.upacademy.repository.ProductRepository;

@Named("ProductBean")
@RequestScoped

public class ProductBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Product newProduct = new Product();

	public Product getNewProduct() {
		return newProduct;
	}

	public void setNewProduct(Product newProduct) {
		this.newProduct = newProduct;
	}

	private Product editedProduct = new Product();

	public Product getEditedProduct() {
		return editedProduct;
	}

	public void setEditedProduct(Product editedProduct) {
		this.editedProduct = editedProduct;
	}

	@Inject
	private ProductRepository productRepository;

	public List<Product> getList() {
		return productRepository.getDbProduct();
	}

	public void addProduct() {
		System.out.println(1);
		newProduct.setCategorySet(categoryRepository.getCategoriesFromNames(categoryNameList));
		System.out.println(newProduct.getCategorySet());
		newProduct.setPlatformSet(platformRepository.getPlatformsFromNames(platformNameList));
		System.out.println(newProduct.getPlatformSet());
		productRepository.addToDb(newProduct);
		System.out.println(productRepository.getDbProduct());
	}

	public void editProduct() {
		productRepository.updateInDb(editedProduct);
	}

	public void deleteProduct(Product product) {
		productRepository.removeFromDb(product);
	}
	
	@Inject
	private PlatformRepository platformRepository;
//	public List<String> existingPlatforms(){
//		List<Platform> existingPlatformsList = platformRepository.getDbPlatforms();
//		List<String> existingPlatformsName = new ArrayList<>();
//		for(Platform platform:existingPlatformsList){
//			existingPlatformsName.add(platform.getPlatformName());
//		}
//		return existingPlatformsName;
//	}
	
	public List<Platform> existingPlatforms(){
		return platformRepository.getDbPlatforms();
	}
	
	@Inject
	private CategoryRepository categoryRepository;
//	public List<String> existingCategories(){
//		List<Category> existingCategoriesList = categoryRepository.getDbCategories();
//		List<String> existingCategoriesName = new ArrayList<>();
//		for(Category category:existingCategoriesList){
//			existingCategoriesName.add(category.getCategoryName());
//		}
//		return existingCategoriesName;
//	}
	
	public List<Category> existingCategories(){
		return categoryRepository.getDbCategories();
	}
	
	private List<String> categoryNameList = new ArrayList<>();

	public List<String> getCategoryNameList() {
		return categoryNameList;
	}

	public void setCategoryNameList(List<String> categoryNameList) {
		this.categoryNameList = categoryNameList;
	}
	
	private List<String> platformNameList = new ArrayList<>();

	public List<String> getPlatformNameList() {
		return categoryNameList;
	}

	public void setPlatformNameList(List<String> platformNameList) {
		this.platformNameList = platformNameList;
	}
	
	public void display(){
		System.out.println(1);
	}
}
