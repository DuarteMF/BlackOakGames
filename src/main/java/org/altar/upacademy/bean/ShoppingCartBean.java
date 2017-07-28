package org.altar.upacademy.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.altar.upacademy.model.Order;
import org.altar.upacademy.model.ProductUnit;
import org.altar.upacademy.repository.OrderRepository;
import org.altar.upacademy.repository.ProductUnitRepository;

@Named("ShoppingCartBean")
@SessionScoped
public class ShoppingCartBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<ProductUnit> cart = new ArrayList<>();

	public List<ProductUnit> getCart() {
		return cart;
	}

	public void setCart(List<ProductUnit> cart) {
		this.cart = cart;
	}
	
	private ProductUnit productUnit = new ProductUnit();
	
	public ProductUnit getProductUnit() {
		return productUnit;
	}
	
	@Inject
	private ProductUnitRepository productUnitRepository;
	
	@Inject
	private ProductPageBean productPageBean;

	public void setProductUnit() {
		ProductUnit productUnit = productUnitRepository.getAvaliableProductUnitFromProductIdAndPlatform(productPageBean.getProductId(), productUnitPlatformId);
		this.productUnit = productUnit;
	}

	private LocalDate startDate;
	private LocalDate endDate;
	
	private Double expectedPrice = 0.0;

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
		setProductUnit();
		cart.add(productUnit);
		return "success";
	}
	
	public void removeFromCart(){
		cart.remove(productUnit);
	}
	
	private Order order = new Order();
	
	@Inject
	private OrderRepository orderRepository;
	
	public String createOrder(){
		order.setProductUnitSet(cart.stream().collect(Collectors.toSet()));
//		order.setClient(client);
//		order.setSeller(seller);
		order.setStart(startDate);
		order.setEnd(endDate);
		order.setExpectedPrice(expectedPrice);
		orderRepository.addToDb(order);
		return "success";
	}
	
	public void calculateExpectedPrice(){
		Double totalPricePerWeek = 0.0;
		for(ProductUnit productUnit: cart){
			totalPricePerWeek += productUnit.getProduct().getRentalPrice();
		}
		long numberOfDaysRental = ChronoUnit.DAYS.between(startDate, endDate);
		double priceToTruncate = totalPricePerWeek * (((double) numberOfDaysRental)/7);
		expectedPrice = BigDecimal.valueOf(priceToTruncate).setScale(2, RoundingMode.HALF_UP).doubleValue();
	}
	
	private Integer productUnitPlatformId;

	public Integer getProductUnitPlatformId() {
		return productUnitPlatformId;
	}

	public void setProductUnitPlatformId(Integer productUnitPlatformId) {
		this.productUnitPlatformId = productUnitPlatformId;
	}
	
	public String clean(){
		cart = new ArrayList<>();
		startDate = null;
		endDate = null;
		order = new Order();
		expectedPrice = 0.0;
		return "success";
	}
	
	public String showStartDate(){
		return startDate.format(DateTimeFormatter.ofPattern("d MMM uuuu"));
	}
	
	public String showEndDate(){
		return endDate.format(DateTimeFormatter.ofPattern("d MMM uuuu"));
	}
}
