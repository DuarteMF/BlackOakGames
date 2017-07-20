package org.altar.upacademy.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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

	public void checkProductName() {
		boolean productNameAlreadyExists = false;
		for (Product iteratedProduct : productRepository.getDbProduct()) {
			if (newProduct.getProductName().equals(iteratedProduct.getProductName())) {
				productNameAlreadyExists = true;
				break;
			}
		}
		if (!productNameAlreadyExists) {
			addProduct();
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!",
					"There is already a product with the same name. Please choose another name."));
		}
	}

	public void addProduct() {
		newProduct.setCategorySet(categoryList);
		newProduct.setPlatformSet(platformList);
		productRepository.addToDb(newProduct);
		for (Category category : categoryList) {
			Set<Product> productSetTemp = category.getProductSet();
			productSetTemp.add(newProduct);
			category.setProductSet(productSetTemp);
			categoryRepository.updateInDb(category);
		}
		for (Platform platform : platformList) {
			Set<Product> productSetTemp = platform.getProductSet();
			productSetTemp.add(newProduct);
			platform.setProductSet(productSetTemp);
			platformRepository.updateInDb(platform);
		}
	}

	public void editProduct() {
		Set<Integer> categorySetIds = categoryList.stream().map(n -> n.getCategoryId()).collect(Collectors.toSet());
		Set<Integer> platformSetIds = platformList.stream().map(n -> n.getPlatformId()).collect(Collectors.toSet());
		for (Category category : existingCategories()) {
			Set<Product> productSetTemp = category.getProductSet();
			List<Integer> productSetIds = productSetTemp.stream().map(n -> n.getProductId())
					.collect(Collectors.toList());
			if (productSetIds.contains(editedProduct.getProductId())
					&& !categorySetIds.contains(category.getCategoryId())) {
				productSetIds.remove(editedProduct.getProductId());
			} else if (!productSetIds.contains(editedProduct.getProductId())
					&& categorySetIds.contains(category.getCategoryId())) {
				productSetIds.add(editedProduct.getProductId());
			}
			Set<Product> newProductSetTemp = productRepository.getProductsFromIds(productSetIds);
			category.setProductSet(newProductSetTemp);
			categoryRepository.updateInDb(category);
		}
		for (Platform platform : existingPlatforms()) {
			Set<Product> productSetTemp = platform.getProductSet();
			List<Integer> productSetIds = productSetTemp.stream().map(n -> n.getProductId())
					.collect(Collectors.toList());
			if (productSetIds.contains(editedProduct.getProductId())
					&& !platformSetIds.contains(platform.getPlatformId())) {
				productSetIds.remove(editedProduct.getProductId());
			} else if (!productSetIds.contains(editedProduct.getProductId())
					&& platformSetIds.contains(platform.getPlatformId())) {
				productSetIds.add(editedProduct.getProductId());
			}
			Set<Product> newProductSetTemp = productRepository.getProductsFromIds(productSetIds);
			platform.setProductSet(newProductSetTemp);
			platformRepository.updateInDb(platform);
		}
		editedProduct.setCategorySet(categoryList);
		editedProduct.setPlatformSet(platformList);
		productRepository.updateInDb(editedProduct);
	}

	public void deleteProduct(Product product) {
		for (Category category : product.getCategorySet()) {
			Set<Product> productSetTemp = category.getProductSet();
			productSetTemp.remove(product);
			category.setProductSet(productSetTemp);
			categoryRepository.updateInDb(category);
		}
		for (Platform platform : product.getPlatformSet()) {
			Set<Product> productSetTemp = platform.getProductSet();
			productSetTemp.remove(product);
			platform.setProductSet(productSetTemp);
			platformRepository.updateInDb(platform);
		}
		productRepository.removeFromDb(product);
	}

	@Inject
	private PlatformRepository platformRepository;

	public List<Platform> existingPlatforms() {
		return platformRepository.getDbPlatforms();
	}

	@Inject
	private CategoryRepository categoryRepository;

	public List<Category> existingCategories() {
		return categoryRepository.getDbCategories();
	}

	private Set<Category> categoryList = new HashSet<>();

	public Set<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(Set<Category> categoryList) {
		this.categoryList = categoryList;
	}

	private Set<Platform> platformList = new HashSet<>();

	public Set<Platform> getPlatformList() {
		return platformList;
	}

	public void setPlatformList(Set<Platform> platformList) {
		this.platformList = platformList;
	}
}
