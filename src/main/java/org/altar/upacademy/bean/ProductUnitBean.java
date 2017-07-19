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
		System.out.println(product.getProductId());
		System.out.println(platform.getPlatformId());
		Product testProduct = (Product) productRepository.readFromDb(product.getProductId());
		Platform testPlatform = (Platform) platformRepository.readFromDb(platform.getPlatformId());
//		newProductUnit.setProduct(product);
		System.out.println(testProduct.getProductId());
		newProductUnit.setProduct((Product) productRepository.readFromDb(product.getProductId()));
//		newProductUnit.setProductPlatform(platform);
		System.out.println(testPlatform.getPlatformId());
		newProductUnit.setProductPlatform((Platform) platformRepository.readFromDb(platform.getPlatformId()));
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
		System.out.println(product.getProductId() + " " + product);
		this.product = product;
	}
	
	private Platform platform = new Platform();

	public Platform getPlatform() {
		return platform;
	}

	public void setPlatform(Platform platform) {
		System.out.println(platform.getPlatformId() + " " + platform);
		this.platform = platform;
	}
	
	public Product getProduct(int productId){
		return productRepository.getProductFromId(productId);
	}
}
