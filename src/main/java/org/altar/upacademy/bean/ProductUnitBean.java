package org.altar.upacademy.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.altar.upacademy.model.ProductUnit;
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

	public ProductUnit getEditedproductUnit() {
		return editedProductUnit;
	}

	public void setEditedproductUnit(ProductUnit editedProductUnit) {
		this.editedProductUnit = editedProductUnit;
	}
	
	@Inject
	private ProductUnitRepository productUnitRepository;
	
	public List<ProductUnit> getList(){
		return productUnitRepository.getDbProductUnit();
	}
	
	public void addProductUnit() {
		productUnitRepository.addToDb(newProductUnit);
	}

	public void editProductUnit() {
		productUnitRepository.updateInDb(editedProductUnit);
	}

	public void deleteProductUnit(ProductUnit productUnit) {
		productUnitRepository.removeFromDb(productUnit);
	}
}
