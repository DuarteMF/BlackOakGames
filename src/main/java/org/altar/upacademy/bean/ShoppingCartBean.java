package org.altar.upacademy.bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Set;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.altar.upacademy.model.Order;
import org.altar.upacademy.model.ProductUnit;
import org.altar.upacademy.repository.ProductUnitRepository;

@Named("ShoppingCartBean")
@SessionScoped
public class ShoppingCartBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Set<ProductUnit> cart = new HashSet<>();

	public Set<ProductUnit> getCart() {
		return cart;
	}

	public void setCart(Set<ProductUnit> cart) {
		this.cart = cart;
	}
	
	private ProductUnit productUnit = new ProductUnit();
	
	public ProductUnit getProductUnit() {
		return productUnit;
	}
	
	@Inject
	private ProductUnitRepository productUnitRepository;

	public void setProductUnit() {
		ProductUnit productUnit = productUnitRepository.getAvaliableProductUnitFromProductIdAndPlatform(productId, productUnitPlatformId);
		this.productUnit = productUnit;
	}

	private LocalDate startDate;
	private LocalDate endDate;
	
	private Double expectedPrice;

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Double getExpectedPrice() {
		return expectedPrice;
	}

	public void setExpectedPrice(Double expectedPrice) {
		this.expectedPrice = expectedPrice;
	}
	
	public String addToCart(){
		cart.add(productUnit);
		return "success";
	}
	
	public void removeFromCart(){
		cart.remove(productUnit);
	}
	
	private Order order = new Order();
	
	public void createOrder(){
		order.setProductUnitSet(cart);
//		order.setClient(client);
//		order.setSeller(seller);
		order.setStart(startDate);
		order.setEnd(endDate);
		order.setExpectedPrice(calculateExpectedPrice());
	}
	
	public Double calculateExpectedPrice(){
		Double totalPricePerWeek = 0.0;
		for(ProductUnit productUnit: cart){
			totalPricePerWeek += productUnit.getProduct().getRentalPrice();
		}
		int numberOfDaysRental = Period.between(endDate, startDate).getDays();
		return totalPricePerWeek * (numberOfDaysRental/7);
	}
	
	private Integer productUnitPlatformId;

	public Integer getProductUnitPlatformId() {
		return productUnitPlatformId;
	}

	public void setProductUnitPlatformId(Integer productUnitPlatformId) {
		System.out.println(productUnitPlatformId);
		this.productUnitPlatformId = productUnitPlatformId;
	}
	
	private Integer productId;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		System.out.println(productId);
		this.productId = productId;
	}
}
