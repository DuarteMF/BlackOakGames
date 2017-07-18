package org.altar.upacademy.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.altar.upacademy.model.Platform;
import org.altar.upacademy.model.Product;
import org.altar.upacademy.model.ProductUnit;
import org.altar.upacademy.repository.PlatformRepository;
import org.altar.upacademy.repository.ProductRepository;
import org.altar.upacademy.repository.ProductUnitRepository;

@Named("ProductUnitBean")
@RequestScoped
public class ProductUnitBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private ProductUnit newProductUnit = new ProductUnit();
	
	private ProductUnit editedProductUnit = new ProductUnit();

	public ProductUnit getNewProductUnit() {
		return newProductUnit;
	}

	public void setNewProductUnit(ProductUnit newProductUnit) {
		this.newProductUnit = newProductUnit;
	}

	public ProductUnit getEditedProductUnit() {
		return editedProductUnit;
	}

	public void setEditedProductUnit(ProductUnit editedProductUnit) {
		this.editedProductUnit = editedProductUnit;
	}
	
	@Inject
	private ProductUnitRepository productUnitRepository;
	
	@Inject
	private ProductRepository productRepository;
	
	@Inject
	private PlatformRepository platformRepository;
	
	public List<ProductUnit> getList(){
		return productUnitRepository.getDbProductUnit();
	}
	
	public void addProductUnit() {
		Product product = productRepository.getProductFromName(productName);
		Platform platform = platformRepository.getPlatformFromName(platformName);
		newProductUnit.setProduct(product);
		newProductUnit.setProductPlatform(platform);
		productUnitRepository.addToDb(newProductUnit);
	}

	public void editProductUnit() {
		Product product = productRepository.getProductFromName(productName);
		Platform platform = platformRepository.getPlatformFromName(platformName);
		editedProductUnit.setProduct(product);
		editedProductUnit.setProductPlatform(platform);
		productUnitRepository.updateInDb(editedProductUnit);
	}

	public void deleteProductUnit(ProductUnit productUnit) {
		productUnitRepository.removeFromDb(productUnit);
	}
	
	private String productName = "";

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	private String platformName = null;

	public String getPlatformName() {
		return platformName;
	}

	public void setPlatformName(String platformName) {
		System.out.println(platformName);
		this.platformName = platformName;
	}
	
	public List<String> getProductPlatformList(){
		Product product = productRepository.getProductFromName(productName);
		return product.getPlatformSet().stream().map(n->n.getPlatformName()).collect(Collectors.toList());
	}
	
	private Set<Platform> platformList;

	public Set<Platform> getPlatformList() {
		return platformList;
	}

	public void setPlatformList(Set<Platform> platformList) {
		this.platformList = platformList;
	}
	
	public void display(){
		System.out.println(productName);
		System.out.println(productRepository.getProductFromName(productName));
		System.out.println(productRepository.getProductFromName(productName).getPlatformSet());
		System.out.println(platformName);
	}
}
