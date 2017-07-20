package org.altar.upacademy.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
	
	public void checkPlatform(String typeOfOperation){
		boolean moveToNextStep = false;
		for(Platform iteratedPlatform: product.getPlatformSet()){
			if(iteratedPlatform.getPlatformId() == platform.getPlatformId()){
				moveToNextStep = true;
				break;
			}
		}
		if(moveToNextStep){
			if(typeOfOperation.equals("Addition")){
				addProductUnit();
			}else if(typeOfOperation.equals("Edition")){
				editProductUnit();
			}
		}else{
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "The product you are trying to add/change is not supported for the platform you chose."));
		}
	}
	
	public void addProductUnit() {
		newProductUnit.setProduct(product);
		newProductUnit.setProductPlatform(platform);
		productUnitRepository.addToDb(newProductUnit);
	}

	public void editProductUnit() {
		Product testProduct = (Product) productRepository.readFromDb(product.getProductId());
		Platform testPlatform = (Platform) platformRepository.readFromDb(platform.getPlatformId());
		editedProductUnit.setProduct(testProduct);
		editedProductUnit.setProductPlatform(testPlatform);
		productUnitRepository.updateInDb(editedProductUnit);
	}

	public void deleteProductUnit(ProductUnit productUnit) {
		productUnitRepository.removeFromDb(productUnit);
	}
	
	private Product product = new Product();

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	private Platform platform = new Platform();

	public Platform getPlatform() {
		return platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}
	
	public Product getProduct(int productId){
		return productRepository.getProductFromId(productId);
	}
}
