package org.altar.upacademy.bean;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.altar.upacademy.model.Product;
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
	return productRepository.getDbProducts();
}


public void addProduct() {
	productRepository.addToDb(newProduct);
}

public void editProduct() {
	productRepository.updateInDb(editedProduct);
}

public void deleteProduct(Product product) {
	productRepository.removeFromDb(product);
}
}
