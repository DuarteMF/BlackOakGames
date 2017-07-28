package org.altar.upacademy.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.inject.Named;

import org.altar.upacademy.model.Platform;
import org.altar.upacademy.model.Product;
import org.altar.upacademy.model.ProductUnit;
import org.altar.upacademy.repository.ProductRepository;
import org.altar.upacademy.repository.ProductUnitRepository;
import org.omnifaces.cdi.ViewScoped;
//import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.ViewAccessScoped;

@Named("ProductPageBean")
//@RequestScoped
@ViewScoped
//@ViewAccessScoped
public class ProductPageBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer productId = null;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	@Inject
	private ProductRepository productRepository;
	
	@Inject ProductUnitRepository productUnitRepository;
	
	private Product product;
	
	public Product getProduct(){
		return this.product;
	}
	
	public void setProduct(){
		this.product = productRepository.getProductFromId(productId);
	}
	
	public List<String> availability(){
		List<String> availabilityPerPlatform = new ArrayList<>();
		List<Platform> orderedPlatforms = product.getPlatformSet().stream().sorted((n, m)->n.getPlatformName().compareTo(m.getPlatformName())).collect(Collectors.toList());
		for (Platform platform: orderedPlatforms){
			List<ProductUnit> availableUnits = productUnitRepository.getAvaliableProductUnitsFromProductIdAndPlatform(product.getProductId(), platform.getPlatformId());
			availabilityPerPlatform.add(platform.getPlatformName() + ": " + availableUnits.size());
		}
		return availabilityPerPlatform;
	}
	
	public List<Platform> availablePlatforms(){
		List<Platform> orderedPlatforms = product.getPlatformSet().stream().sorted((n, m)->n.getPlatformName().compareTo(m.getPlatformName())).collect(Collectors.toList());
		return orderedPlatforms;
	}
}
