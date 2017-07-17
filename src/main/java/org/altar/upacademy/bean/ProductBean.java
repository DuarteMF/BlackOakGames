package org.altar.upacademy.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
		Set<Category> categorySet = categoryRepository.getCategoriesFromNames(categoryNameList);
		Set<Platform> platformSet = platformRepository.getPlatformsFromNames(platformNameList);
		newProduct.setCategorySet(categorySet);
		newProduct.setPlatformSet(platformSet);
		productRepository.addToDb(newProduct);	
		for(Category category: categorySet){
			Set<Product> productSetTemp = category.getProductSet();
			productSetTemp.add(newProduct);
			category.setProductSet(productSetTemp);
			categoryRepository.updateInDb(category);
		}
		for(Platform platform: platformSet){
			Set<Product> productSetTemp = platform.getProductSet();
			productSetTemp.add(newProduct);
			platform.setProductSet(productSetTemp);
			platformRepository.updateInDb(platform);
		}	
	}

	public void editProduct() {
		Set<Category> categorySet = categoryRepository.getCategoriesFromNames(categoryNameList);
		Set<String> categorySetNames = categorySet.stream().map(n->n.getCategoryName()).collect(Collectors.toSet());
		Set<Platform> platformSet = platformRepository.getPlatformsFromNames(platformNameList);
		Set<String> platformSetNames = platformSet.stream().map(n->n.getPlatformName()).collect(Collectors.toSet());
		for(Category category: existingCategories()){
			Set<Product> productSetTemp = category.getProductSet();
			List<String> productSetNames = productSetTemp.stream().map(n->n.getProductName()).collect(Collectors.toList());
			if(productSetNames.contains(editedProduct.getProductName()) && !categorySetNames.contains(category.getCategoryName())){
				productSetNames.remove(editedProduct.getProductName());
			}else if(!productSetNames.contains(editedProduct.getProductName()) && categorySetNames.contains(category.getCategoryName())){
				productSetNames.add(editedProduct.getProductName());
			}
			Set<Product> newProductSetTemp = productRepository.getProductsFromNames(productSetNames);
			category.setProductSet(newProductSetTemp);
			categoryRepository.updateInDb(category);
		}
		for(Platform platform: existingPlatforms()){
			Set<Product> productSetTemp = platform.getProductSet();
			List<String> productSetNames = productSetTemp.stream().map(n->n.getProductName()).collect(Collectors.toList());
			if(productSetNames.contains(editedProduct.getProductName()) && !platformSetNames.contains(platform.getPlatformName())){
				productSetNames.remove(editedProduct.getProductName());
			}else if(!productSetNames.contains(editedProduct.getProductName()) && platformSetNames.contains(platform.getPlatformName())){
				productSetNames.add(editedProduct.getProductName());
			}
			Set<Product> newProductSetTemp = productRepository.getProductsFromNames(productSetNames);
			platform.setProductSet(newProductSetTemp);
			platformRepository.updateInDb(platform);			
		}
		editedProduct.setCategorySet(categorySet);
		editedProduct.setPlatformSet(platformSet);
		productRepository.updateInDb(editedProduct);
	}

	public void deleteProduct(Product product) {
		for(Category category: product.getCategorySet()){
			Set<Product> productSetTemp = category.getProductSet();
			productSetTemp.remove(product);
			category.setProductSet(productSetTemp);
			categoryRepository.updateInDb(category);
		}
		for(Platform platform: product.getPlatformSet()){
			Set<Product> productSetTemp = platform.getProductSet();
			productSetTemp.remove(product);
			platform.setProductSet(productSetTemp);
			platformRepository.updateInDb(platform);
		}
		productRepository.removeFromDb(product);
	}
	
	@Inject
	private PlatformRepository platformRepository;
	
	public List<Platform> existingPlatforms(){
		return platformRepository.getDbPlatforms();
	}
	
	@Inject
	private CategoryRepository categoryRepository;
	
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
	
//	private Set<Category> oldCategorySet;
//	private Set<Platform> oldPlatformSet;
//
//	public Set<Category> getOldCategorySet() {
//		return oldCategorySet;
//	}
//
//	public void setOldCategorySet(Set<Category> oldCategorySet) {
//		this.oldCategorySet = oldCategorySet;
//	}
//
//	public Set<Platform> getOldPlatformSet() {
//		return oldPlatformSet;
//	}
//
//	public void setOldPlatformSet(Set<Platform> oldPlatformSet) {
//		this.oldPlatformSet = oldPlatformSet;
//	}
}
